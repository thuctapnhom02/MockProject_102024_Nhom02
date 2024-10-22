from django.contrib import admin
from django.urls import path
from . import views
urlpatterns = [
    path('', views.Home, name="Home"),
    path('Login/', views.Login, name='Login'),
    path('Admin/', views.Admin, name='Admin'),
    path('InformationBuilding/',views.InformationBuilding,name='InformationBuilding'),
    path('TechnicalSystem/',views.TechnicalSystem,name="TechnicalSystem"),
]
