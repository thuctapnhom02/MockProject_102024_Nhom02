from django import forms
from .models import System

class SystemSearchForm(forms.ModelForm):
    class Meta:
        model = System
        fields = ['system_id', 'location', 'status']