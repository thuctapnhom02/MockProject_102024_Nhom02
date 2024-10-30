from rest_framework import serializers
from rest_framework.serializers import ModelSerializer
from .models import Apartment, Role, Staff, Building, TechnicalMaintenance, TechnicalRepair, MaintenanceRepair
class ApartmentSerializer(serializers.ModelSerializer):
    class Meta:
        model = Apartment
        fields = '__all__'

class BuildingSerializer(serializers.ModelSerializer):
    apartments = ApartmentSerializer(many = True, read_only=True)

    class Meta:
        model = Building
        fields = ['area', 'build_year', 'num_apartments', 'apartments']
class TechnicalMaintenanceSerializer(serializers.ModelSerializer):
    equipment_name = serializers.CharField(source='equipment.name')
    equipment_id = serializers.CharField(source='equipment.id')
    equipment_type = serializers.CharField(source='equipment.id_type.name')
    class Meta:
        model = TechnicalMaintenance
        fields = '__all__'
class TechnicalRepairSerializer(serializers.ModelSerializer):
    equipment_name = serializers.CharField(source='equipment.name')
    equipment_id = serializers.CharField(source='equipment.id')

    class Meta:
        model = TechnicalRepair
        fields="__all__"
class MaintenanceRepairSerializer(serializers.ModelSerializer):
    class Meta:
        model = MaintenanceRepair
        fields ='__all__'
