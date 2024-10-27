from django.contrib import admin
from django.urls import path
from . import views
from .views import staff_login_view, BuildingDetailAPI, InformationBuildingAPI, ApartmentAPI, TechnicalSystemAPI,MaintenanceRepairViewSet
from rest_framework.routers import DefaultRouter


maintenance_repair_list = MaintenanceRepairViewSet.as_view({'get': 'list', 'post': 'create'})
maintenance_repair_detail = MaintenanceRepairViewSet.as_view({'get': 'retrieve', 'put': 'update', 'delete': 'destroy'})

urlpatterns = [
    #path('', views.Login, name="Login"),
    # path('Login/', views.Login, name='Login'),
    
    path('Login/', staff_login_view, name='Login'),
    path('Admin/', views.Admin, name='Admin'),
    path('InformationBuilding', views.InformationBuilding, name='InformationBuilding'),
    path('TechnicalSystem/',views.TechnicalSystem,name="TechnicalSystem"),
    path('get-add-form/', views.get_add_form, name='get-add-form'),
    path('Repair/', views.Repair, name ='Repair'),



    path('api/information-building/', InformationBuildingAPI.as_view(), name='information-building-api'),
    path('api/building/<int:pk>/', BuildingDetailAPI.as_view(), name='building-detail'),
    path('api/apartments/', ApartmentAPI.as_view(), name='apartment-api'),
    path('api/technical-system/', TechnicalSystemAPI.as_view(), name='technical_system_api'),
    path('api/maintenance-repair/', maintenance_repair_list, name='maintenance_repair_list'), 
    path('api/maintenance-repair/<str:pk>/', maintenance_repair_detail, name='maintenance_repair_detail'), 
]
