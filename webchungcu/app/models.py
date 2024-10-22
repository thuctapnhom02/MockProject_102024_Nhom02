from django.db import models
class System(models.Model):
    system_id = models.CharField(max_length=10)
    location = models.CharField(max_length=50)
    status = models.CharField(max_length=20)
    nearest_maintenance = models.DateField()
    next_maintenance = models.DateField()

    def __str__(self):
        return self.system_id
# Create your models here.
from django import template
register = template.Library()
@register.simple_tag
def to_list(*args):
    return args