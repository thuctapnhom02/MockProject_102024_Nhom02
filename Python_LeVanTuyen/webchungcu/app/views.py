from django.shortcuts import render, redirect
import requests

from django.http import HttpResponse, JsonResponse
from app.models import User, TechnicalMaintenance, TechnicalRepair, MaintenanceRepair
from app.models import Staff, Role, Equipment,Apartment, Building
from django.contrib.auth.views import LoginView
from django.urls import reverse_lazy
from django.contrib.auth import authenticate, login
from django.contrib import messages
from collections import defaultdict
from rest_framework import viewsets, generics, status
from rest_framework.views import APIView
from rest_framework.response import Response
from app.serializers import ApartmentSerializer, BuildingSerializer, TechnicalMaintenanceSerializer, MaintenanceRepairSerializer
# Create your views here.

def fetch_apartments(request):
    response = requests.get('')

def Home(request):
    context = {}
    return render(request, 'app/Home.html')
def InformationBuilding(request):
    return render(request, 'app/InformationBuilding.html')

def staff_list_view(request):
    staffs = Staff.objects.all() 

def staff_login_view(request):
    if request.method == 'POST':
        phonenumber = request.POST['phonenumber']
        password = request.POST['password']
        print(f'Phone: {phonenumber}, Password: {password}')
        if 'signup' in request.POST:
            # Logic để xử lý đăng ký
            return redirect('SignUpPage')
        try:
            staff = Staff.objects.get(phone=phonenumber)

            if staff.password==password:
                request.session['staff_id'] = staff.id
                return redirect('InformationBuilding')
            else:               
                messages.error(request, 'Phone or password is false')
                return redirect('Login')
        except Staff.DoesNotExist:
            messages.error(request, 'Phone or password is false')
            return redirect('Login')
    return render(request, 'app/Login.html')
# class CustomLoginView(LoginView):
#     template_name = 'app/Login.html'
#     success_url = reverse_lazy('InformationBuilding')
#     def form_valid(self, form):
#         remember_me = self.request.POST.get('remember_me', None)
#         if not remember_me:
#             self.request.session.set_expiry(0)
#         return super().form_valid(form)
# def Login(request):
#      context = {}
#      return render(request, 'app/Login.html')
def Repair(request):
    context={}
    return render(request,'app/Repair.html')
def Admin(request):
    context = {}
    return render(request,'app/Admin.html')
def TechnicalSystem(request):
    return render(request, 'app/TechnicalSystem.html')
def get_add_form(request):
    return render(request, 'app/TechSysAdd.html')

#API
class BuildingDetailAPI(generics.RetrieveAPIView):
    queryset = Building.objects.all()
    serializer_class = BuildingSerializer

class InformationBuildingAPI(APIView):
    def get(self, request):
        building = Building.objects.first()
        if building:
            serializer = BuildingSerializer(building)
            return Response(serializer.data)
        return Response({"error": "Building not found"}, status=404)

class ApartmentAPI(APIView):
    def get(self, request):
        apartments = Apartment.objects.all()
        if apartments:
            serializer = ApartmentSerializer(apartments, many=True)
            return Response(serializer.data)
        return Response({"error": "Apartment not found"}, status=404)
class TechnicalSystemAPI(generics.ListAPIView):
    queryset = TechnicalMaintenance.objects.select_related('equipment__id_type').all()
    serializer_class = TechnicalMaintenanceSerializer

    def list(self, request, *args, **kwagrs):
        technical_maintenances = self.get_queryset()

        equipment_names = {maintenance.equipment.name for maintenance in technical_maintenances}
        maintenance_statuses = {maintenance.status for maintenance in technical_maintenances}
        equipment_types = {maintenance.equipment.id_type.name for maintenance in technical_maintenances}
        data = {
            'TechnicalMaintenances': self.get_serializer(technical_maintenances, many=True).data,
            'equipment_names': list(equipment_names),
            'maintenance_statuses': list(maintenance_statuses),
            'equipment_types': list(equipment_types),
        }
        return Response(data)

class MaintenanceRepairViewSet(viewsets.ViewSet):
    queryset = MaintenanceRepair.objects.all()
    serializer_class = MaintenanceRepairSerializer

    def list(self, request):
        queryset = MaintenanceRepair.objects.all()
        serializer = MaintenanceRepairSerializer(queryset, many=True)
        return Response(serializer.data)

    def create(self, request):
        serializer = MaintenanceRepairSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def retrieve(self, request, pk=None):
        try:
            maintenance_repair = MaintenanceRepair.objects.get(pk=pk)
        except MaintenanceRepair.DoesNotExist:
            return Response(status=status.HTTP_404_NOT_FOUND)

        serializer = MaintenanceRepairSerializer(maintenance_repair)
        return Response(serializer.data)

    def update(self, request, pk=None):
        try:
            maintenance_repair = MaintenanceRepair.objects.get(pk=pk)
        except MaintenanceRepair.DoesNotExist:
            return Response(status=status.HTTP_404_NOT_FOUND)

        serializer = MaintenanceRepairSerializer(maintenance_repair, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def destroy(self, request, pk=None):
        try:
            maintenance_repair = MaintenanceRepair.objects.get(pk=pk)
        except MaintenanceRepair.DoesNotExist:
            return Response(status=status.HTTP_404_NOT_FOUND)

        maintenance_repair.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)