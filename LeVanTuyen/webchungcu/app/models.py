from django.db import models
from django.contrib.auth.models import User
from django.contrib.auth.hashers import make_password, check_password


class User(models.Model):
    delete_status = models.BooleanField(default=False, db_column='delete_status_')
    day_delete = models.DateTimeField(null=True, blank=True, db_column='day_delete_')
    id = models.CharField(max_length=60, primary_key=True, db_column='id_')
    name = models.CharField(max_length=255, db_column='name_')
    email = models.EmailField(max_length=255, db_column='email_')
    phone = models.CharField(max_length=30, db_column='phone_')
    gender = models.CharField(max_length=10, db_column='gender_')
    ssn = models.CharField(max_length=9, db_column='ssn_')  # Social Security Number
    status = models.CharField(max_length=60, db_column='status_')
    password = models.CharField(max_length=255, db_column='password_')
    debt = models.DecimalField(max_digits=10, decimal_places=2, db_column='debt_')
    total_payment = models.DecimalField(max_digits=10, decimal_places=2, db_column='total_payment_')
    start_day = models.DateTimeField(db_column='start_day_')
    end_day = models.DateTimeField(null=True, blank=True, db_column='end_day_')
    address = models.CharField(max_length=255, db_column='address_')

    class Meta:
        db_table = 'user_'
        managed = False


class Staff(models.Model):
    delete_status = models.BooleanField(default=False, db_column='delete_status_')
    day_delete = models.DateTimeField(null=True, blank=True, db_column='day_delete_')
    id = models.CharField(max_length=60, primary_key=True, db_column='id_')
    id_role = models.CharField(max_length=60, db_column='id_role_')
    name = models.CharField(max_length=255, db_column='name_')
    phone = models.CharField(max_length=30, db_column='phone_')
    gender = models.CharField(max_length=10, db_column='gender_')
    start_day = models.DateTimeField(db_column='start_day_')
    end_day = models.DateTimeField(null=True, blank=True, db_column='end_day_')
    status = models.CharField(max_length=60, db_column='status_')
    password = models.CharField(max_length=255, db_column='password_')
    address = models.CharField(max_length=255, db_column='address_')
    
    class Meta:
        db_table = 'staff_'
        managed = False

    def set_password(self, raw_password):
        self.password = make_password(raw_password)

    def check_password(self, raw_password):
        return check_password(raw_password, self.password)
class Role(models.Model):
    delete_status = models.BooleanField(default=False,db_column='delete_status_')
    day_delete = models.DateTimeField(null=True,blank=True,db_column='day_delete_')
    id = models.CharField(max_length=60, primary_key=True, db_column='id_')
    name_role = models.CharField(max_length=255, db_column='name_role_')

class Supplier(models.Model):
    delete_status = models.BooleanField(default=False, db_column='delete_status_')
    day_delete = models.DateTimeField(null=True, blank=True, db_column='day_delete_')
    id = models.CharField(max_length=60, primary_key=True, db_column='id_')
    name = models.CharField(max_length=255, db_column='name_')
    phone = models.CharField(max_length=30, db_column='phone_')
    address = models.CharField(max_length=255, db_column='address_')

    class Meta:
        db_table = 'suppliers_'
        managed = False

class Building(models.Model):
    area = models.DecimalField(max_digits=5, decimal_places=2, default=200000.00)
    build_year = models.IntegerField(default=2020)
    num_apartments = models.IntegerField(default=90)

class Apartment(models.Model):
    delete_status = models.BooleanField(default=False, db_column='delete_status_')
    day_delete = models.DateTimeField(null=True, blank=True, db_column='day_delete_')
    id = models.CharField(max_length=60, primary_key=True, db_column='id_')
    floor = models.IntegerField(db_column='flor_')
    status = models.CharField(max_length=60, db_column='status_')
    num_apartment = models.CharField(max_length=255, db_column='num_apartment_')
    num_bedroom = models.IntegerField(db_column='num_bedroom_')
    square = models.DecimalField(max_digits=10, decimal_places=2, db_column='square_')
    rent_price = models.DecimalField(max_digits=10, decimal_places=2, db_column='rent_price_')
    address = models.CharField(max_length=255, db_column='address_')
    #active = models.BooleanField(default=True)
    class Meta:
        db_table = 'apartment_'
        managed = False
class TypeEquipment(models.Model):
    delete_status = models.BooleanField(default=False, db_column='delete_status_')
    day_delete = models.DateTimeField(null=True, blank=True, db_column='day_delete_')
    id = models.CharField(max_length=60, primary_key=True, db_column='id_')
    name = models.CharField(max_length=255, db_column='name_')
    class Meta:
        db_table = 'type_equipment_'
        managed = False

class Equipment(models.Model):
    delete_status = models.BooleanField(default=False, db_column='delete_status_')
    day_delete = models.DateTimeField(null=True, blank=True, db_column='day_delete_')
    id = models.CharField(max_length=60, primary_key=True, db_column='id_')
    name = models.CharField(max_length=150, db_column='name_')
    warranty = models.DateTimeField(null=True, blank=True, db_column='warranty_')
    date_purchase = models.DateTimeField(null=True, blank=True, db_column='date_purchase_')
    maintenance_date = models.DateTimeField(null=True, blank=True, db_column='maintenance_date_')
    location = models.TextField(null=True, blank=True, db_column='location_')
    status = models.CharField(max_length=60, db_column='status_')
    id_type = models.ForeignKey(TypeEquipment, on_delete=models.CASCADE, db_column='id_type_', related_name='type')
    class Meta:
        db_table = 'equipment_'
        managed = False
# class ContractLease(models.Model):
#     delete_status = models.BooleanField(default=False)
#     day_delete = models.DateTimeField(null=True, blank=True)
#     id = models.CharField(max_length=60, primary_key=True)
#     id_user = models.CharField(max_length=60)
#     id_staff = models.CharField(max_length=60)
#     status = models.CharField(max_length=60)
#     contact_info = models.CharField(max_length=255)
#     rental_fee = models.TextField()  # Vì trường này là kiểu text
#     payment_period = models.DateTimeField()
#     lease_start_date = models.DateTimeField()
#     lease_end_date = models.DateTimeField(null=True, blank=True)
#     id_suppliers = models.CharField(max_length=60)
#     id_apartment = models.CharField(max_length=60)

#     class Meta:
#         db_table = 'contract_lease_'
#         verbose_name = 'Contract Lease'
#         verbose_name_plural = 'Contract Leases'

#     def __str__(self):
#         return f"Contract {self.id} - {self.status}"

# class ContractService(models.Model):
#     delete_status = models.BooleanField(default=False)
#     day_delete = models.DateTimeField(null=True, blank=True)
#     id_contract = models.CharField(max_length=255, primary_key=True)
#     id_user = models.CharField(max_length=60)
#     id_staff = models.CharField(max_length=60)
#     start_contract = models.DateTimeField()
#     end_contract = models.DateTimeField(null=True, blank=True)
#     scope_of_the_contract = models.TextField()
#     quality_standards = models.TextField()
#     id_suppliers = models.CharField(max_length=60)
#     status = models.CharField(max_length=60)

#     class Meta:
#         db_table = 'contract_service_'
#         verbose_name = 'Contract Service'
#         verbose_name_plural = 'Contract Services'

#     def __str__(self):
#         return f"Contract {self.id_contract} - {self.status}"

# class UtilityContract(models.Model):
#     delete_status = models.BooleanField(default=False)
#     day_delete = models.DateTimeField(null=True, blank=True)
#     id_contract = models.CharField(max_length=255, primary_key=True)
#     start_day = models.DateTimeField()
#     end_day = models.DateTimeField(null=True, blank=True)
#     type_of_utility = models.TextField()
#     price = models.DecimalField(max_digits=10, decimal_places=2)
#     status = models.CharField(max_length=60)
#     id_user = models.CharField(max_length=60)
#     id_suppliers = models.CharField(max_length=60)
#     id_staff = models.CharField(max_length=60)

#     class Meta:
#         db_table = 'utility_contract_'
#         verbose_name = 'Utility Contract'
#         verbose_name_plural = 'Utility Contracts'

#     def __str__(self):
#         return f"Utility Contract {self.id_contract} - {self.status}"

# class EmploymentContract(models.Model):
#     delete_status = models.BooleanField(default=False)
#     day_delete = models.DateTimeField(null=True, blank=True)
#     id = models.CharField(max_length=60, primary_key=True)
#     status = models.CharField(max_length=60)
#     name = models.CharField(max_length=255)
#     phone = models.CharField(max_length=30)
#     email = models.EmailField(max_length=255)
#     id_user = models.CharField(max_length=60)
#     id_staff = models.CharField(max_length=60)
#     id_suppliers = models.CharField(max_length=60)

#     class Meta:
#         db_table = 'employment_contract_'
#         verbose_name = 'Employment Contract'
#         verbose_name_plural = 'Employment Contracts'

#     def __str__(self):
#         return f"Employment Contract {self.id} - {self.name}"

class TechnicalMaintenance(models.Model):
    delete_status = models.BooleanField(default=False, db_column='delete_status_')
    day_delete = models.DateTimeField(null=True, blank=True, db_column='day_delete_')
    id = models.CharField(max_length=60, primary_key=True, db_column='id_')
    id_staff_send = models.CharField(max_length=60, db_column='id_staff_send_')
    id_staff_action = models.CharField(max_length=60, db_column='id_staff_action_')
    status = models.CharField(max_length=255, db_column='status_')
    name = models.CharField(max_length=255, db_column='name_')
    nearest_maintenance = models.DateTimeField(null=True, blank=True, db_column='nearest_maintenance_')
    next_maintenance = models.DateTimeField(null=True, blank=True, db_column='next_maintenance_')
    location = models.CharField(max_length=255, db_column='location_')
    maintenance_task = models.CharField(max_length=255, db_column='maintenance_task_')
    description = models.TextField(null=True, blank=True, db_column='description_')
    floor = models.IntegerField(db_column='floor_')

    equipment = models.ForeignKey(Equipment, on_delete=models.CASCADE, db_column='id_equipment_', related_name='maintenances')
    
    class Meta:
        db_table = 'technical_maintenance_'
        managed = False



class TechnicalRepair(models.Model):
    delete_status = models.BooleanField(default=False, db_column='delete_status_')
    day_delete = models.DateTimeField(null=True, blank=True, db_column='day_delete_')
    id = models.CharField(max_length=60, primary_key=True, db_column='id_')
    id_staff_send = models.CharField(max_length=60, db_column='id_staff_send_')
    id_staff_action = models.CharField(max_length=60, db_column='id_staff_action_')
    status = models.CharField(max_length=255, db_column='status_')
    name = models.CharField(max_length=255, db_column='name_')
    nearest_repair = models.DateTimeField(null=True, blank=True, db_column='nearest_repair_')
    next_repair = models.DateTimeField(null=True, blank=True, db_column='next_repair_')
    location = models.CharField(max_length=255, db_column='location_')
    repair_task = models.CharField(max_length=255, db_column='repair_task_')
    description = models.TextField(null=True, blank=True, db_column='description_')
    floor = models.IntegerField(db_column='floor_')
    id_equipment = models.CharField(max_length=60, db_column='id_equipment_')

    class Meta:
        db_table = 'technical_repair_'
        managed = False

    def __str__(self):
        return self.name
    
class Payment(models.Model):
    delete_status = models.BooleanField(default=False)
    day_delete = models.DateTimeField(null=True, blank=True)
    id = models.CharField(max_length=60, primary_key=True)
    user_id = models.CharField(max_length=60)
    id_service = models.CharField(max_length=60)
    id_income = models.CharField(max_length=60)
    status = models.CharField(max_length=60)
    total = models.DecimalField(max_digits=10, decimal_places=2)
    payment_dateline = models.DateTimeField()
    id_type_payment = models.CharField(max_length=60)

    class Meta:
        db_table = 'payment_'
        managed = False

    def __str__(self):
        return f"Payment {self.id} - Status: {self.status}"

class Complaint(models.Model):
    delete_status = models.BooleanField(default=False)
    day_delete = models.DateTimeField(null=True, blank=True)
    id = models.CharField(max_length=60, primary_key=True)
    id_apartment = models.CharField(max_length=60)
    id_user = models.CharField(max_length=60)
    complaint_date = models.DateTimeField()
    expected_completion_date = models.DateTimeField(null=True, blank=True)
    content_of_complaint = models.TextField()
    proof_img = models.TextField(null=True, blank=True)  # Có thể chứa đường dẫn đến hình ảnh
    id_staff = models.CharField(max_length=60)
    note = models.TextField(null=True, blank=True)
    status = models.CharField(max_length=255)

    class Meta:
        db_table = 'complaints_'
        managed = False

    def __str__(self):
        return f"Complaint {self.id} - Status: {self.status}"

class RentalRequest(models.Model):
    delete_status = models.BooleanField(default=False)
    day_delete = models.DateTimeField(null=True, blank=True)
    id = models.CharField(max_length=60, primary_key=True)
    id_apartment = models.CharField(max_length=60)
    tenant_name = models.CharField(max_length=255)
    date_of_birth = models.DateTimeField()
    address = models.CharField(max_length=255)
    phone = models.CharField(max_length=30)
    email = models.EmailField(max_length=255)
    job = models.CharField(max_length=255)
    status = models.CharField(max_length=255)

    class Meta:
        db_table = 'rental_request_'
        managed = False

    def __str__(self):
        return f"Rental Request {self.id} - Tenant: {self.tenant_name}"
class MaintenanceRepair(models.Model):
    delete_status = models.BooleanField(default=False, db_column='delete_status_')  # tương ứng với `tinyint`
    day_delete = models.DateTimeField(null=True, blank=True, db_column='day_delete_')
    id = models.CharField(max_length=60, primary_key=True, db_column='id_')
    id_user = models.CharField(max_length=60, db_column='id_user_')
    id_apartment = models.CharField(max_length=60, db_column='id_apartment_')
    expected_completion_date = models.DateTimeField(null=True, blank=True, db_column='expected_completion_date_')
    repair_content = models.TextField(db_column='repair_content_')
    condition_of_damage = models.TextField(db_column='condition_of_damage_')
    id_equipment = models.CharField(max_length=60, db_column='id_equipment_')

    class Meta:
        managed = False
        db_table = 'maintenance_repair_'  # Tên bảng trong cơ sở dữ liệu
        unique_together = ('id', 'id_equipment')  # Thiết lập khóa phụ
class ScheduleHomeInspection(models.Model):
    delete_status = models.BooleanField(default=False)
    day_delete = models.DateTimeField(null=True, blank=True)
    id = models.CharField(max_length=60, primary_key=True)
    id_apartment = models.CharField(max_length=60)
    name = models.CharField(max_length=255)
    phone = models.CharField(max_length=30)
    date = models.DateTimeField()
    status = models.CharField(max_length=255)

    class Meta:
        db_table = 'schedule_a_home_inspection_'
        managed = False

    def __str__(self):
        return f"Inspection {self.id} - Name: {self.name}"

# class Income(models.Model):
#     delete_status = models.BooleanField(default=False)
#     day_delete = models.DateTimeField(null=True, blank=True)
#     id = models.CharField(max_length=60, primary_key=True)
#     id_user = models.CharField(max_length=60)
#     id_apartment = models.CharField(max_length=60)
#     status = models.CharField(max_length=60)
#     id_service = models.CharField(max_length=60)
#     id_payment_method = models.CharField(max_length=60)
#     total = models.CharField(max_length=60)  # Nếu total là số, có thể sử dụng DecimalField thay cho CharField
#     payment_deadline = models.CharField(max_length=60)  # Cũng có thể là DateTimeField nếu chứa ngày
#     id_type_income = models.CharField(max_length=60)

#     class Meta:
#         db_table = 'income_'
#         verbose_name = 'Income'
#         verbose_name_plural = 'Incomes'

#     def __str__(self):
#         return f"Income {self.id} - Status: {self.status}"

# class Outcome(models.Model):
#     delete_status = models.BooleanField(default=False)
#     day_delete = models.DateTimeField(null=True, blank=True)
#     id = models.CharField(max_length=60, primary_key=True)
#     status = models.CharField(max_length=255)
#     name_service = models.CharField(max_length=255)
#     description = models.TextField(null=True, blank=True)  # Đã sửa lỗi chính tả từ 'deription_' thành 'description'
#     price = models.DecimalField(max_digits=10, decimal_places=2)
#     id_type_outcome = models.CharField(max_length=60)
#     id_repair_history = models.CharField(max_length=60)

#     class Meta:
#         db_table = 'outcome_'
#         verbose_name = 'Outcome'
#         verbose_name_plural = 'Outcomes'

#     def __str__(self):
#         return f"Outcome {self.id} - Service: {self.name_service}"
    
# class NotificationStaff(models.Model):
#     delete_status = models.BooleanField(default=False)
#     day_delete = models.DateTimeField(null=True, blank=True)
#     id = models.CharField(max_length=60, primary_key=True)
#     id_user = models.CharField(max_length=60)
#     id_staff = models.CharField(max_length=60)
#     title = models.CharField(max_length=255)
#     description = models.TextField(null=True, blank=True)  # Đã sửa lỗi chính tả từ 'deription_' thành 'description'
#     notice_date = models.DateTimeField()
#     sender = models.CharField(max_length=255)

#     class Meta:
#         db_table = 'notification_staff_'
#         verbose_name = 'Notification Staff'
#         verbose_name_plural = 'Notifications Staff'

#     def __str__(self):
#         return f"Notification {self.id} - Title: {self.title}"



from django import template
register = template.Library()
@register.simple_tag
def to_list(*args):
    return args
