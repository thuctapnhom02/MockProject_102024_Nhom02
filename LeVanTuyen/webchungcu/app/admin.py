from django.contrib import admin
from .models import *

# Register your models here.
admin.site.register(User)
admin.site.register(Staff)
admin.site.register(Supplier)
admin.site.register(Apartment)
admin.site.register(TechnicalMaintenance)
admin.site.register(TechnicalRepair)
