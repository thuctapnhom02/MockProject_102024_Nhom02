from django.shortcuts import render
from django.http import HttpResponse
from .models import System
from .forms import SystemSearchForm

# Create your views here.
def Home(request):
    context = {}
    return render(request, 'app/Home.html')
def Login(request):
    context = {}
    return render(request, 'app/Login.html')
def Admin(request):
    context = {}
    return render(request,'app/Admin.html')
def TechnicalSystem(request):
    context = {}
    return render(request, 'app/TechnicalSystem.html')
def InformationBuilding(request):
    context = {}
    return render(request, 'app/InformationBuilding.html')
def system_list_technical(request):
    form = SystemSearchForm(request.GET)
    if form.is_valid():
        systems = systems.filter(**form.cleaned_data)
    return render(request, 'app/TechnicalSystem.html',{'systems': systems, 'form': form})

