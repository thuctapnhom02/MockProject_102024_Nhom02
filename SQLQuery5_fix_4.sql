create database webchungcu_
go
use webchungcu_
go
create table user_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  name_ varchar(255),
  email_ varchar(255),
  phone_ varchar(30),
  gender_ varchar(10),
  ssn_ varchar(9),
  status_ varchar(60),
  password_ varchar(255),
  debt_ decimal,
  total_payment_ decimal,
  start_day_ datetime,
  end_day_ datetime,
  address_ varchar(255)
)
go

create table staff_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  id_role_ varchar(60),
  name_ varchar(255),
  phone_ varchar(30),
  gender_ varchar(10),
  start_day_ datetime,
  end_day_ datetime,
  status_ varchar(60),
  password_ varchar(255),
  address_ varchar(255)
)
go

create table suppliers_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  name_ varchar(255),
  phone_ varchar(30),
  address_ varchar(255)
)
go

create table apartment_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  flor_ int,
  status_ varchar(60),
  num_apartment_ varchar(255),
  num_bedroom_ int,
  square_ decimal,
  rent_price_ decimal,
  address_ varchar(255)
)
go

create table contract_lease_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  id_user_ varchar(60),
  id_staff_ varchar(60),
  status_ varchar(60),
  contact_info_ varchar(255),
  rental_fee_ text,
  payment_period_ datetime,
  lease_start_date_ datetime,
  lease_end_date_ datetime,
  id_suppliers_ varchar(60),
  id_apartment_ varchar(60)
)
go

create table contract_service_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_contract_ varchar(255) primary key,
  id_user_ varchar(60),
  id_staff_ varchar(60),
  start_contract_ datetime,
  end_contract_ datetime,
  scope_of_the_contract_ text,
  quality_standards_ text,
  id_suppliers_ varchar(60),
  status_ varchar(60)
)
go

create table utility_contract_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_contract_ varchar(255) primary key,
  start_day_ datetime,
  end_day_ datetime,
  type_of_utility_ text,
  price_ decimal,
  status_ varchar(60),
  id_user_ varchar(60),
  id_suppliers_ varchar(60),
  id_staff_ varchar(60)
)
go

create table employment_contract_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  status_ varchar(60),
  name_ varchar(255),
  phone_ varchar(30),
  email_ varchar(255),
  id_user_ varchar(60),
  id_staff_ varchar(60),
  id_suppliers_ varchar(60)
)
go

create table technical_maintenance_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  id_staff_send_ varchar(60),
  id_staff_action_ varchar(60),
  status_ varchar(255),
  name_ varchar(255),
  nearest_maintenance_ datetime,
  next_maintenance_ datetime,
  location_ varchar(255),
  maintenance_task_ varchar(255),
  description_ text,
  floor_ int,
  id_equipment_ varchar(60)
)
go

create table technical_repair_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  id_staff_send_ varchar(60),
  id_staff_action_ varchar(60),
  status_ varchar(255),
  name_ varchar(255),
  nearest_repair_ datetime,
  next_repair_ datetime,
  location_ varchar(255),
  repair_task_ varchar(255),
  description_ text,
  floor_ int,
  id_equipment_ varchar(60)
)
go

create table payment_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  user_id_ varchar(60),
  id_service_ varchar(60),
  id_income_ varchar(60),
  status_ varchar(60),
  total_ decimal,
  payment_dateline_ datetime,
  id_payment_method_ varchar(60)
)
go

create table complaints_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  id_apartment_ varchar(60),
  id_user_ varchar(60),
  complaint_date_ datetime,
  expected_completion_date_ datetime,
  content_of_complaint_ text,
  proof_img_ text,
  id_staff_ varchar(60),
  note_ text,
  status_ varchar(255)
)
go

create table rental_request_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  id_apartment_ varchar(60),
  tenant_name_ varchar(255),
  date_of_birth_ datetime,
  address_ varchar(255),
  phone_ varchar(30),
  email_ varchar(255),
  job_ varchar(255),
  status_ varchar(255)
)
go

create table schedule_a_home_inspection_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  id_apartment_ varchar(60),
  name_ varchar(255),
  phone_ varchar(30),
  date_ datetime,
  status_ varchar(255)
)
go

create table income_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  id_user_ varchar(60),
  id_apartment_ varchar(60),
  status_ varchar(60),
  id_service_ varchar(60),
  id_payment_method_ varchar(60),
  total_ varchar(60),
  payment_deadline_ varchar(60),
  id_type_income_ varchar(60)
)
go

create table outcome_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  status_ varchar(255),
  name_service_ varchar(255),
  deription_ text,
  price_ decimal,
  id_type_outcome_ varchar(60),
  id_repair_history_ varchar(60)
)
go

create table notification_staff_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  id_user_ varchar(60),
  id_staff_ varchar(60),
  title_ varchar(255),
  deription_ text,
  notice_date_ datetime,
  sender_ varchar(255)
)
go

create table type_outcome_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  name_type_ varchar(255)
)
go

create table type_income_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  name_type_ varchar(255)
)
go

create table repair_history_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  id_equiptment_ varchar(60),
  repair_maintenance_date_ datetime,
  price_ decimal,
  describe_ text,
  id_staff_ varchar(60)
)
go

create table type_equipment_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  name_ varchar(255)
)
go

create table payment_method_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  name_method_ varchar(255)
)
go

create table role_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  name_role_ varchar(255)
)
go

create table service_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  name_ varchar(255),
  price_ decimal(10,0),
  regulation_ varchar(255),
  deription_ text
)
go

create table equipment_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  name_ varchar(150),
  warranty_ datetime,
  date_purchase_ datetime,
  maintenance_date_ datetime,
  id_type_ varchar(60),
  location_ text,
  status_ varchar(60)
)
go

create table maintenance_repair_ (
  delete_status_ tinyint,
  day_delete_ datetime,
  id_ varchar(60) primary key,
  id_user_ varchar(60),
  id_apartment_ varchar(60),
  expected_completion_date_ datetime,
  repair_content_ text,
  condition_of_damage_ text,
  id_equipment_ varchar(60)
)


go

alter table staff_ add foreign key (id_role_) references role_ (id_)
go

alter table contract_lease_ add foreign key (id_user_) references user_ (id_)
go

alter table contract_lease_ add foreign key (id_staff_) references staff_ (id_)
go

alter table contract_lease_ add foreign key (id_suppliers_) references suppliers_ (id_)
go

alter table contract_lease_ add foreign key (id_apartment_) references apartment_ (id_)
go

alter table contract_service_ add foreign key (id_user_) references user_ (id_)
go

alter table contract_service_ add foreign key (id_staff_) references staff_ (id_)
go

alter table contract_service_ add foreign key (id_suppliers_) references suppliers_ (id_)
go

alter table utility_contract_ add foreign key (id_user_) references user_ (id_)
go

alter table utility_contract_ add foreign key (id_staff_) references staff_ (id_)
go

alter table utility_contract_ add foreign key (id_suppliers_) references suppliers_ (id_)
go

alter table employment_contract_ add foreign key (id_staff_) references staff_ (id_)
go

alter table employment_contract_ add foreign key (id_suppliers_) references suppliers_ (id_)
go

alter table employment_contract_ add foreign key (id_user_) references user_ (id_)
go

alter table technical_maintenance_ add foreign key (id_staff_action_) references staff_ (id_)
go

alter table technical_maintenance_ add foreign key (id_staff_send_) references staff_ (id_)
go

alter table technical_repair_ add foreign key (id_staff_action_) references staff_ (id_)
go

alter table technical_repair_ add foreign key (id_staff_send_) references staff_ (id_)
go

alter table maintenance_repair_ add foreign key (id_user_) references user_ (id_)
go

alter table maintenance_repair_ add foreign key (id_apartment_) references apartment_ (id_)
go


alter table payment_ add foreign key (id_income_) references income_ (id_)
go

alter table payment_ add foreign key (id_service_) references service_ (id_)
go

alter table payment_ add foreign key (id_payment_method_) references payment_method_(id_)
go

alter table payment_ add foreign key (user_id_) references user_ (id_)
go

alter table complaints_ add foreign key (id_apartment_) references apartment_ (id_)
go

alter table complaints_ add foreign key (id_user_) references user_ (id_)
go
alter table complaints_ add foreign key (id_staff_) references staff_ (id_)
go
alter table rental_request_ add foreign key (id_apartment_) references apartment_ (id_)
go

alter table schedule_a_home_inspection_ add foreign key (id_apartment_) references apartment_ (id_)
go

alter table notification_staff_ add foreign key (id_staff_) references staff_ (id_)
go

alter table notification_staff_ add foreign key (id_user_) references user_ (id_)
go

alter table income_ add foreign key (id_apartment_) references apartment_ (id_)
go

alter table income_ add foreign key (id_payment_method_) references payment_method_ (id_)
go

alter table income_ add foreign key (id_type_income_) references type_income_ (id_)
go

alter table income_ add foreign key (id_user_) references user_ (id_)
go

alter table income_ add foreign key (id_service_) references service_ (id_)
go

alter table outcome_ add foreign key (id_type_outcome_) references type_outcome_ (id_)
go
alter table outcome_ add foreign key (id_repair_history_) references  repair_history_(id_)
go
alter table equipment_ add foreign key (id_type_) references type_equipment_ (id_)
go

alter table technical_maintenance_ add foreign key (id_equipment_) references equipment_ (id_)
go

alter table technical_repair_ add foreign key (id_equipment_) references equipment_ (id_)
go

alter table repair_history_ add foreign key (id_equiptment_) references equipment_ (id_)
go

alter table repair_history_ add foreign key (id_staff_) references staff_ (id_)
go

alter table maintenance_repair_ add foreign key (id_equipment_) references equipment_ (id_)



--insert
go
INSERT INTO role_ (id_, name_role_,delete_status_,day_delete_)
VALUES 
('ld9IHnBnqb', 'Admin',1,NULL),
('YGVuciJXWa', 'Staff Repair',1,NULL),
('6GXNX1quQT', 'Staff Maintenance',1,NULL),
('ZO3wFXLHBz', 'Staff Complant',1,NULL),
('etBOQSHUls', 'Staff Request',1,NULL),
('sFqoly3NOB', 'Staff Income',1,NULL),
('EohvfZnaiz', 'Staff Outcome',1,NULL)

go
INSERT INTO service_ (id_, name_,price_,regulation_,deription_,delete_status_,day_delete_)
VALUES 
('Q4zsZ37P3K', 'Flit Service Clean up',100,'no','no',1,NULL),
('4DDBfdJRhX', 'Parking Service',100,'no','no',1,NULL),
('pKg6dIj43p', 'Rent Service',100,'no','no',1,NULL)

go
INSERT INTO payment_method_ (id_,name_method_,delete_status_,day_delete_)
VALUES 
('tGQdMp0Kal', 'Online pay',1,NULL),
('LAT0MMpFe8', 'QR code pay',1,NULL),
('rIi2FOJyFZ', 'cash pay',1,NULL)

go
INSERT INTO type_income_ (id_,name_type_,delete_status_,day_delete_)
VALUES 
('iDLCIOD34H', 'Rent a house income',1,NULL),
('svelFQ4S2s', 'Service clean up',1,NULL),
('pZb51pC2GO', 'Service parking',1,NULL)

go
INSERT INTO type_outcome_ (id_,name_type_,delete_status_,day_delete_)
VALUES 
('R9YFawG2hn', 'Repair equipment',1,NULL),
('skt6a561hH', 'Maintenance equipment',1,NULL)

go
INSERT INTO type_equipment_(id_,name_,delete_status_,day_delete_)
VALUES 
('cjpIFjzqyN', 'lamp',1,NULL),
('LfPbFhXcWl', 'painting',1,NULL)

go
INSERT INTO suppliers_ (id_, name_, phone_, address_,delete_status_,day_delete_)
VALUES
('SUP001', 'Tech Supplies Co.', '0989000001', '123 Tech Street, District 1, HCMC',1,NULL),
('SUP002', 'Building Solutions Ltd.', '0989000002', '456 Construction Ave, District 2, HCMC',1,NULL),
('SUP003', 'Maintenance Experts Corp.', '0989000003', '789 Maintenance Blvd, District 3, HCMC',1,NULL),
('SUP004', 'Safety Equipment Providers', '0989000004', '101 Safety Lane, District 4, HCMC',1,NULL),
('SUP005', 'Power Systems Ltd.', '0989000005', '102 Energy Road, District 5, HCMC',1,NULL),
('SUP006', 'HVAC Solutions Inc.', '0989000006', '103 HVAC Street, District 6, HCMC',1,NULL),
('SUP007', 'Lighting Innovations Co.', '0989000007', '104 Bright Avenue, District 7, HCMC',1,NULL),
('SUP008', 'Security Solutions Ltd.', '0989000008', '105 Secure Blvd, District 8, HCMC',1,NULL),
('SUP009', 'Plumbing Experts LLC', '0989000009', '106 Plumbing Lane, District 9, HCMC',1,NULL),
('SUP010', 'Electrical Supplies Corp.', '0989000010', '107 Electrical Ave, District 10, HCMC',1,NULL),
('SUP011', 'Construction Materials Co.', '0989000011', '108 Build Street, District 11, HCMC',1,NULL),
('SUP012', 'Mechanical Services Ltd.', '0989000012', '109 Mechanics Blvd, District 12, HCMC',1,NULL),
('SUP013', 'Fire Safety Systems Ltd.', '0989000013', '110 Fireproof Lane, District 3, HCMC',1,NULL),
('SUP014', 'HVAC Masters Inc.', '0989000014', '111 Cooling Avenue, District 4, HCMC',1,NULL),
('SUP015', 'Generator Supplies Corp.', '0989000015', '112 Power Drive, District 5, HCMC',1,NULL),
('SUP016', 'Elevator Systems Ltd.', '0989000016', '113 Lift Street, District 6, HCMC',1,NULL),
('SUP017', 'Pest Control Providers', '0989000017', '114 Clean Drive, District 7, HCMC',1,NULL),
('SUP018', 'Water Solutions Corp.', '0989000018', '115 Aqua Lane, District 8, HCMC',1,NULL),
('SUP019', 'Furniture Supplies Ltd.', '0989000019', '116 Comfort Blvd, District 9, HCMC',1,NULL),
('SUP020', 'Cleaning Experts Inc.', '0989000020', '117 Shine Street, District 10, HCMC',1,NULL);

go
INSERT INTO equipment_ (id_, name_, warranty_, date_purchase_, maintenance_date_, id_type_, location_,status_,delete_status_,day_delete_)
VALUES
('EQP001', 'HVAC system', 2026-01-01, 2023-01-10, 2023-06-10, 'cjpIFjzqyN', 'Floor 2', '1',1,NULL),
('EQP002', 'Elevator System', 2027-03-01, 2023-03-05, 2023-08-05, 'LfPbFhXcWl', 'Floor 5', '1',1,NULL),
('EQP003', 'Electric System', 2026-05-15, 2023-05-20, 2023-10-20, 'cjpIFjzqyN', 'Floor 1', '1',1,NULL),
('EQP004', 'Electrical distribution cabinet system', 2025-07-10, 2023-07-15, 2023-12-15, 'LfPbFhXcWl', 'Ground', '1',1,NULL),
('EQP005', 'Fire protection system', 2028-09-20, 2023-09-25, 2024-02-25, 'cjpIFjzqyN', 'Floor 7', '1',1,NULL),
('EQP006', 'Water supply and drainage system', 2026-11-30, 2023-11-05, 2024-04-05, 'LfPbFhXcWl', 'Floor 9', '1',1,NULL),
('EQP007', 'Camera Security System', 2027-12-15, 2023-12-20, 2024-05-20, 'cjpIFjzqyN', 'Floor 6', '1',1,NULL),
('EQP008', 'Elevator System', 2026-02-25, 2023-02-28, 2023-07-28, 'LfPbFhXcWl', 'Floor 4', '1',1,NULL),
('EQP009', 'Electric System', 2025-04-01, 2023-04-10, 2023-09-10, 'cjpIFjzqyN', 'Ground', '1',1,NULL),
('EQP010', 'Fire protection system', 2027-05-20, 2023-05-30, 2023-10-30, 'LfPbFhXcWl', 'Floor 8', '1',1,NULL),
('EQP011', 'Fire protection system', 2026-06-10, 2023-06-12, 2023-12-12, 'cjpIFjzqyN', 'Floor 3', '1',1,NULL),
('EQP012', 'Water supply and drainage system', 2025-08-25, 2023-08-30, 2024-01-30, 'LfPbFhXcWl', 'Floor 2', '1',1,NULL),
('EQP013', 'Camera Security System', 2027-01-15, 2023-01-20, 2023-07-20, 'cjpIFjzqyN', 'Floor 7', '1',1,NULL),
('EQP014', 'Camera Security System', 2026-03-05, 2023-03-10, 2023-09-10, 'LfPbFhXcWl', 'Security Office', '1',1,NULL),
('EQP015', 'HVAC system', 2025-12-12, 2023-12-15, 2024-05-15, 'cjpIFjzqyN', ' Floor 4', '1',1,NULL),
('EQP016', 'Water supply and drainage system', 2028-02-20, 2023-02-22, 2023-07-22, 'LfPbFhXcWl', 'Floor 7', '1',1,NULL),
('EQP017', 'HVAC system', 2026-04-10, 2023-04-12, 2023-09-12, 'cjpIFjzqyN', 'Floor 3', '1',1,NULL),
('EQP018', 'Electrical distribution cabinet system', 2025-11-01, 2023-11-05, 2024-04-05, 'LfPbFhXcWl', 'Ground', '1',1,NULL),
('EQP019', 'Elevator System', 2027-07-15, 2023-07-20, 2024-01-20, 'cjpIFjzqyN', 'Floor 3', '1',1,NULL),
('EQP020', 'Fire protection system', 2026-08-25, 2023-08-30, 2024-02-30, 'LfPbFhXcWl', 'Floor 9', '1',1,NULL);

go
INSERT INTO user_ (id_, name_, email_, phone_, gender_, ssn_, status_, password_,debt_,total_payment_,start_day_,end_day_,address_,delete_status_,day_delete_)
VALUES 
('USR0001', 'Alice Johnson', 'alice.johnson@email.com','0981760001', 'Female', '123456789', '1', 'TempPwd123!',1000,2000,2021-04-05,2028-04-05,'TP.HCM',1,NULL),
('USR0002',  'Robert Smith', 'robert.smith@email.com','0981093752', 'Male', '987654321', '1', 'SecurePass456@',1000,2000,2021-04-05,2028-04-05,'TP.HCM',1,NULL),
('USR0003',  'Charlie Evans', 'charlie.evans@email.com','0981345003', 'Male', '456789123', '1', 'RandomStr789#',1000,2000,2021-04-05,2028-04-05,'TP.HCM',1,NULL),
('USR0004',  'Sophia Taylor', 'sophia.taylor@email.com','0931055004', 'Female', '789123456', '1', 'TempPass321$',1000,2000,2021-04-05,2028-04-05,'TP.HCM',1,NULL),
('USR0005',  'David Brown', 'david.brown@email.com','0981000005', 'Male', '321654987', '1', 'InitialPwd567%',1000,2000,2021-04-05,2028-04-05,'TP.HCM',1,NULL),
('USR0006',  'David Bru','emily.davis@email.com','0981000006', 'Female', '654987321', '1', 'NewUser890^',1000,2000,2021-04-05,2028-04-05,'TP.HCM',1,NULL),
('USR0007', 'Michael Wilson', 'michael.wilson@email.com','0981000007', 'Male', '147258369', '1', 'WelcomePwd246&',1000,2000,2021-04-05,2028-04-05,'TP.HCM',1,NULL),
('USR0008', 'Emma Anderson', 'emma.anderson@email.com','0981476008', 'Female', '258369147', '1', 'FirstLogin135*',1000,2000,2021-04-05,2028-04-05,'TP.HCM',1,NULL),
('USR0009',  'Oliver Thomas', 'oliver.thomas@email.com','0987550010', 'Male', '369147258', '1', 'ChangeMeLater468(',1000,2000,2021-04-05,2028-04-05,'TP.HCM',1,NULL),
('USR0010', 'Liam Jackson', 'liam.jackson@email.com','0985670011', 'Male', '741852963', '1', 'TemporaryAccess579)',1000,2000,2021-04-05,2028-04-05,'TP.HCM',1,NULL),
('USR0011',  'Charlotte Martin', 'charlotte.martin@email.com','0983220014', 'Female', '852963741', '1', 'InitialSetup802!',1000,2000,2021-04-05,2028-04-05,'TP.HCM',1,NULL),
('USR0012',  'Benjamin Lee', 'benjamin.lee@email.com','0985450015', 'Male', '963741852', '1', 'NewAccount913@',1000,2000,2021-04-05,2028-04-05,'TP.HCM',1,NULL),
('USR0013',  'Ella Walker', 'ella.walker@email.com','0983077016', 'Female', '159263478', '1', 'FirstTimeLogin624#',1000,2000,2021-04-05,2028-04-05,'TP.HCM',1,NULL),
('USR0014',  'Lucas Allen', 'lucas.allen@email.com','0971050418', 'Male', '263478159', '1', 'WelcomeUser735$',1000,2000,2021-04-05,2028-04-05,'TP.HCM',1,NULL),
('USR0015',  'Matthew Cooper', 'matthew.cooper@email.com','0982550027', 'Male', '478159263', '1', 'ChangeASAP846%',1000,2000,2021-04-05,2028-04-05,'TP.HCM',1,NULL),
('USR0016',  'Grace Adams', 'grace.adams@email.com','0983010723', 'Female', '951753684', '1', 'TempAccess957^',1000,2000,2021-04-05,2028-04-05,'TP.HCM',1,NULL),
('USR0017',  'William Nelson', 'william.nelson@email.com','0915500424', 'Male', '753684951', '1', 'InitialPwd168&',1000,2000,2021-04-05,2028-04-05,'TP.HCM',1,NULL),
('USR0018',  'Anthony Murphy', 'anthony.murphy@email.com','0971065029', 'Male', '684951753', '1', 'NewUserSetup279*',1000,2000,2021-04-05,2028-04-05,'TP.HCM',1,NULL),
('USR0019',  'Victoria Carter', 'victoria.carter@email.com','0945300034', 'Female', '357159864', '1', 'FirstLoginPwd380',1000,2000,2021-04-05,2028-04-05,'TP.HCM',1,NULL),
('USR0020',  'Amelia Young', 'amelia.young@email.com','0981545019', 'Female', '159864357', '1', 'ChangeMe491',1000,2000,2021-04-05,2028-04-05,'TP.HCM',1,NULL);


go
INSERT INTO apartment_(id_,flor_,num_apartment_,num_bedroom_,square_,rent_price_,status_,delete_status_,day_delete_) 
Values
('APM_001',1,'L1_001',2,30,1000,1,1,NULL),
('APM_002',1,'L1_002',2,30,1000,1,1,NULL),
('APM_003',1,'L1_003',2,30,1000,1,1,NULL),
('APM_004',1,'L1_004',2,30,1000,1,1,NULL),
('APM_005',1,'L1_005',2,30,1000,1,1,NULL),
('APM_006',1,'L1_006',2,30,1000,1,1,NULL),
('APM_007',1,'L1_007',2,30,1000,1,1,NULL),
('APM_008',1,'L1_008',2,30,1000,1,1,NULL),
('APM_009',1,'L1_009',2,30,1000,1,1,NULL),
('APM_0010',1,'L1_0010',2,30,1000,1,1,NULL),
('APM_0011',1,'L1_0011',2,30,1000,1,1,NULL),
('APM_0012',1,'L1_0012',2,30,1000,1,1,NULL),
('APM_0013',1,'L1_0013',2,30,1000,1,1,NULL),
('APM_0014',1,'L1_0014',2,30,1000,1,1,NULL),
('APM_0015',1,'L1_0015',2,30,1000,1,1,NULL),
('APM_0016',1,'L1_0016',2,30,1000,1,1,NULL),
('APM_0017',1,'L1_0017',2,30,1000,1,1,NULL),
('APM_0018',1,'L1_0018',2,30,1000,1,1,NULL),
('APM_0019',1,'L1_0019',2,30,1000,1,1,NULL),
('APM_0020',1,'L1_0020',2,30,1000,1,1,NULL);

go
INSERT INTO staff_
           (id_, id_role_, name_, phone_, gender_, start_day_, end_day_, status_, password_,address_,delete_status_,day_delete_)
VALUES
('ST0000001', 'ld9IHnBnqb', 'Alice Johnson', '0981000001', 'Female', 2022-01-10, 2026-12-28, 1, 'admin123','TP.HCM',1,NULL),
('ST0000002', 'YGVuciJXWa', 'Robert Smith', '0981000002', 'Male', 2023-03-15, 2026-12-28, 1, 'repair123','TP.HCM',1,NULL),
('ST0000003', '6GXNX1quQT', 'Charlie Evans', '0981000003', 'Male', 2023-05-20, 2026-12-28, 1, 'maintenance123','TP.HCM',1,NULL),
('ST0000004', 'ZO3wFXLHBz', 'Sophia Taylor', '0981000004', 'Female', 2021-07-25, 2026-12-28, 1, 'complaint123','TP.HCM',1,NULL),
('ST0000005', 'etBOQSHUls', 'David Brown', '0981000005', 'Male', 2023-01-05, 2026-12-28, 1, 'request123','TP.HCM',1,NULL),
('ST0000006', 'sFqoly3NOB', 'Emily Davis', '0981000006', 'Female', 2022-09-12, 2026-12-28, 1, 'income123','TP.HCM',1,NULL),
('ST0000007', 'EohvfZnaiz', 'Michael Wilson', '0981000007', 'Male', 2021-11-18, 2026-12-28, 1, 'outcome123','TP.HCM',1,NULL),
('ST0000008', 'YGVuciJXWa', 'John Miller', '0981000008', 'Male', 2022-08-30, 2026-12-28, 1, 'repair123','TP.HCM',1,NULL),
('ST0000009', '6GXNX1quQT', 'Emma Anderson', '0981000009', 'Female', 2023-04-17, 2026-12-28, 1, 'maintenance123','TP.HCM',1,NULL),
('ST0000010', 'ZO3wFXLHBz', 'Oliver Thomas', '0981000010', 'Male', 2022-06-21, 2026-12-28, 1, 'complaint123','TP.HCM',1,NULL),
('ST0000011', 'etBOQSHUls', 'Liam Jackson', '0981000011', 'Male', 2023-08-05, 2026-12-28, 1, 'request123','TP.HCM',1,NULL),
('ST0000012', 'sFqoly3NOB', 'Sophia White', '0981000012', 'Female', 2022-10-10, 2026-12-28, 1, 'income123','TP.HCM',1,NULL),
('ST0000013', 'EohvfZnaiz', 'James Harris', '0981000013', 'Male', 2021-12-28, 2026-12-28, 1, 'outcome123','TP.HCM',1,NULL),
('ST0000014', 'ld9IHnBnqb', 'Charlotte Martin', '0981000014', 'Female', 2022-11-15, 2026-12-28, 1, 'admin123','TP.HCM',1,NULL),
('ST0000015', 'YGVuciJXWa', 'Benjamin Lee', '0981000015', 'Male', 2023-02-13, 2026-12-28, 1, 'repair123','TP.HCM',1,NULL),
('ST0000016', '6GXNX1quQT', 'Ella Walker', '0981000016', 'Female', 2021-05-18, 2026-12-28, 1, 'maintenance123','TP.HCM',1,NULL),
('ST0000017', 'ZO3wFXLHBz', 'Jack Hall', '0981000017', 'Male', 2022-04-07, 2026-12-28, 1, 'complaint123','TP.HCM',1,NULL),
('ST0000018', 'etBOQSHUls', 'Lucas Allen', '0981000018', 'Male', 2023-07-25, 2026-12-28, 1, 'request123','TP.HCM',1,NULL),
('ST0000019', 'sFqoly3NOB', 'Amelia Young', '0981000019', 'Female', 2022-01-20, 2026-12-28, 1, 'income123','TP.HCM',1,NULL),
('ST0000020', 'EohvfZnaiz', 'Daniel King', '0981000020', 'Male', 2021-09-10, 2026-12-28, 1, 'outcome123','TP.HCM',1,NULL),
('ST0000021', 'ld9IHnBnqb', 'Mia Scott', '0981000021', 'Female', 2023-06-11, 2026-12-28, 1, 'admin123','TP.HCM',1,NULL),
('ST0000022', 'YGVuciJXWa', 'Henry Green', '0981000022', 'Male', 2022-12-22, 2026-12-28, 1, 'repair123','TP.HCM',1,NULL),
('ST0000023', '6GXNX1quQT', 'Grace Adams', '0981000023', 'Female', 2021-08-16, 2026-12-28, 1, 'maintenance123','TP.HCM',1,NULL),
('ST0000024', 'ZO3wFXLHBz', 'William Nelson', '0981000024', 'Male', 2023-03-02, 2026-12-28, 1, 'complaint123','TP.HCM',1,NULL),
('ST0000025', 'etBOQSHUls', 'Ethan Hill', '0981000025', 'Male', 2021-07-29, 2026-12-28, 1, 'request123','TP.HCM',1,NULL),
('ST0000026', 'sFqoly3NOB', 'Isabella Perez', '0981000026', 'Female', 2022-02-11, 2026-12-28, 1, 'income123','TP.HCM',1,NULL),
('ST0000027', 'EohvfZnaiz', 'Matthew Cooper', '0981000027', 'Male', 2023-05-01, 2026-12-28, 1, 'outcome123','TP.HCM',1,NULL),
('ST0000028', 'ld9IHnBnqb', 'Harper Baker', '0981000028', 'Female', 2021-06-24, 2026-12-28, 1, 'admin123','TP.HCM',1,NULL),
('ST0000029', 'YGVuciJXWa', 'Anthony Murphy', '0981000029', 'Male', 2023-09-19, 2026-12-28, 1, 'repair123','TP.HCM',1,NULL),
('ST0000030', '6GXNX1quQT', 'Victoria Carter', '0981000030', 'Female', 2022-03-27, 2026-12-28, 1, 'maintenance123','TP.HCM',1,NULL);

go
INSERT INTO contract_lease_ (id_, id_user_, id_staff_,status_, contact_info_, rental_fee_, payment_period_, lease_start_date_, lease_end_date_, id_suppliers_, id_apartment_,delete_status_,day_delete_)
VALUES
('CT0000001', 'USR0001', 'ST0000001', '1', 'Alice Johnson, 0981760001', '500', '2024-01-01', '2024-01-10', '2024-12-31', 'SUP001', 'APM_001',1,NULL),
('CT0000002', 'USR0002', 'ST0000002', '1', 'Robert Smith, 0981093752', '700', '2024-01-01', '2024-02-01', '2025-01-31', 'SUP001', 'APM_002',1,NULL),
('CT0000003', 'USR0003', 'ST0000003', '1', 'Charlie Evans, 0981345003', '600', '2024-01-01', '2024-03-01', '2025-02-28', 'SUP001', 'APM_003',1,NULL),
('CT0000004', 'USR0004', 'ST0000004', '1', 'Sophia Taylor, 0931055004', '800', '2024-01-01', '2024-04-01', '2025-03-31', 'SUP001', 'APM_004',1,NULL),
('CT0000005', 'USR0005', 'ST0000005', '1', 'David Brown, 0981000005', '450', '2024-01-01', '2024-05-01', '2025-04-30', 'SUP001', 'APM_005',1,NULL),
('CT0000006', 'USR0006', 'ST0000006', '1', 'Emily Davis, 0981000006', '550', '2024-01-01', '2024-06-01', '2025-05-31', 'SUP001', 'APM_006',1,NULL),
('CT0000007', 'USR0007', 'ST0000007', '1', 'Michael Wilson, 0981000007', '600', '2024-01-01', '2024-07-01', '2025-06-30', 'SUP001', 'APM_007',1,NULL),
('CT0000008', 'USR0008', 'ST0000008', '1', 'Emma Anderson, 0981476008', '700', '2024-01-01', '2024-08-01', '2025-07-31', 'SUP001', 'APM_008',1,NULL),
('CT0000009', 'USR0009', 'ST0000009', '1', 'Oliver Thomas, 0987550010', '650', '2024-01-01', '2024-09-01', '2025-08-31', 'SUP001', 'APM_009',1,NULL),
('CT0000010', 'USR0010', 'ST0000010', '1', 'Liam Jackson, 0985670011', '720', '2024-01-01', '2024-10-01', '2025-09-30', 'SUP001', 'APM_0010',1,NULL),
('CT0000011', 'USR0011', 'ST0000011', '1', 'Charlotte Martin, 0983220014', '480', '2024-01-01', '2024-11-01', '2025-10-31', 'SUP001', 'APM_0011',1,NULL),
('CT0000012', 'USR0012', 'ST0000012', '1', 'Benjamin Lee, 0985450015', '530', '2024-01-01', '2024-12-01', '2025-11-30', 'SUP001', 'APM_0012',1,NULL),
('CT0000013', 'USR0013', 'ST0000013', '1', 'Ella Walker, 0983077016', '670', '2024-01-01', '2025-01-01', '2025-12-31', 'SUP001', 'APM_0013',1,NULL),
('CT0000014', 'USR0014', 'ST0000014', '1', 'Lucas Allen, 0971050418', '740', '2024-01-01', '2025-02-01', '2026-01-31', 'SUP001', 'APM_0014',1,NULL),
('CT0000015', 'USR0015', 'ST0000015', '1', 'Matthew Cooper, 0982550027', '500', '2024-01-01', '2025-03-01', '2026-02-28', 'SUP001', 'APM_0015',1,NULL),
('CT0000016', 'USR0016', 'ST0000015', '1', 'Grace Adams, 0983010723', '600', '2024-01-01', '2025-04-01', '2026-03-31', 'SUP001', 'APM_0016',1,NULL),
('CT0000017', 'USR0017', 'ST0000017', '1', 'William Nelson, 0915500424', '700', '2024-01-01', '2025-05-01', '2026-04-30', 'SUP001', 'APM_0017',1,NULL),
('CT0000018', 'USR0018', 'ST0000018', '1', 'Anthony Murphy, 0971065029', '750', '2024-01-01', '2025-06-01', '2026-05-31', 'SUP001', 'APM_0018',1,NULL),
('CT0000019', 'USR0019', 'ST0000019', '1', 'Victoria Carter, 0945300034', '800', '2024-01-01', '2025-07-01', '2026-06-30', 'SUP001', 'APM_0019',1,NULL),
('CT0000020', 'USR0020', 'ST0000020', '1', 'Amelia Young, 0981545019', '550', '2024-01-01', '2025-08-01', '2026-07-31', 'SUP001', 'APM_0020',1,NULL);

go
INSERT INTO contract_service_ (id_contract_, id_user_, id_staff_, start_contract_, end_contract_, scope_of_the_contract_, quality_standards_, id_suppliers_, status_,delete_status_,day_delete_)
VALUES
('CT0000001', 'USR0001', 'ST0000001', '2021-01-01', '2024-12-31', '3', 'Normal', 'SUP001', '1',1,NULL),
('CT0000002', 'USR0002', 'ST0000002', '2021-02-01', '2025-01-31', '4', 'Normal', 'SUP001', '1',1,NULL),
('CT0000003', 'USR0003', 'ST0000003', '2021-03-01', '2025-02-28', '4', 'Normal', 'SUP001', '1',1,NULL),
('CT0000004', 'USR0004', 'ST0000004', '2021-04-01', '2026-03-31','5', 'Normal', 'SUP001', '1',1,NULL),
('CT0000005', 'USR0005', 'ST0000005', '2021-05-01', '2026-04-30', '5', 'Normal', 'SUP001', '1',1,NULL),
('CT0000006', 'USR0006', 'ST0000006', '2022-06-01', '2027-05-31', '5', 'Normal', 'SUP001', '1',1,NULL),
('CT0000007', 'USR0007', 'ST0000007', '2022-07-01', '2025-06-30', '3', 'Normal', 'SUP001', '1',1,NULL),
('CT0000008', 'USR0008', 'ST0000008', '2022-08-01', '2025-07-31', '3', 'Normal', 'SUP001', '1',1,NULL),
('CT0000009', 'USR0009', 'ST0000009', '2022-09-01', '2024-08-31', '2', 'Normal', 'SUP001', '1',1,NULL),
('CT0000010', 'USR0010', 'ST0000010', '2022-10-01', '2023-09-30', '1', 'Normal', 'SUP001', '1',1,NULL),
('CT0000011', 'USR0011', 'ST0000011', '2022-11-01', '2025-10-31', '3', 'Normal', 'SUP001', '1',1,NULL),
('CT0000012', 'USR0012', 'ST0000012', '2023-12-01', '2025-11-30', '2', 'Normal', 'SUP001', '1',1,NULL),
('CT0000013', 'USR0013', 'ST0000013', '2023-01-01', '2024-12-31', '1', 'Normal', 'SUP001', '1',1,NULL),
('CT0000014', 'USR0014', 'ST0000014', '2023-02-01', '2026-01-31', '3', 'Normal', 'SUP001', '1',1,NULL),
('CT0000015', 'USR0015', 'ST0000015', '2023-03-01', '2026-02-28', '3', 'Normal', 'SUP001', '1',1,NULL),
('CT0000016', 'USR0016', 'ST0000015', '2023-04-01', '2024-03-31', '1', 'Normal', 'SUP001', '1',1,NULL),
('CT0000017', 'USR0017', 'ST0000017', '2024-05-01', '2026-04-30', '2', 'Normal', 'SUP001', '1',1,NULL),
('CT0000018', 'USR0018', 'ST0000018', '2024-06-01', '2025-05-31', '1', 'Normal', 'SUP001', '1',1,NULL),
('CT0000019', 'USR0019', 'ST0000019', '2024-07-01', '2025-06-30', '1', 'Normal', 'SUP001', '1',1,NULL),
('CT0000020', 'USR0020', 'ST0000020', '2024-08-01', '2026-07-31', '2', 'Normal', 'SUP001', '1',1,NULL);

go
INSERT INTO utility_contract_ (id_contract_, start_day_, end_day_, type_of_utility_, price_, status_, id_user_, id_suppliers_, id_staff_,delete_status_,day_delete_)
VALUES
('UC001', '2023-01-01', '2024-01-01', 'Electricity', 15000, 'Active', 'USR0001', 'SUP001', 'ST0000001',1,NULL),
('UC002', '2023-02-01', '2024-02-01', 'Water', 5000, 'Active', 'USR0002', 'SUP002', 'ST0000002',1,NULL),
('UC003', '2023-03-01', '2024-03-01', 'Gas', 7500, 'Active', 'USR0003', 'SUP003', 'ST0000003',1,NULL),
('UC004', '2023-04-01', '2024-04-01', 'Internet', 10000, 'Active', 'USR0004', 'SUP004', 'ST0000004',1,NULL),
('UC005', '2023-05-01', '2024-05-01', 'Waste Management', 6000, 'Active', 'USR0005', 'SUP005', 'ST0000005',1,NULL),
('UC006', '2023-06-01', '2024-06-01', 'Cable TV', 12000, 'Active', 'USR0006', 'SUP006', 'ST0000006',1,NULL),
('UC007', '2023-07-01', '2024-07-01', 'Security', 20000, 'Active', 'USR0007', 'SUP007', 'ST0000007',1,NULL),
('UC008', '2023-08-01', '2024-08-01', 'Cleaning', 9000, 'Active', 'USR0008', 'SUP008', 'ST0000008',1,NULL),
('UC009', '2023-09-01', '2024-09-01', 'Heating', 11000, 'Active', 'USR0009', 'SUP009', 'ST0000009',1,NULL),
('UC010', '2023-10-01', '2024-10-01', 'Cooling', 13000, 'Active', 'USR0010', 'SUP010', 'ST0000010',1,NULL),
('UC011', '2023-11-01', '2024-11-01', 'Pest Control', 15000, 'Active', 'USR0011', 'SUP011', 'ST0000011',1,NULL),
('UC012', '2023-12-01', '2024-12-01', 'Landscaping', 18000, 'Active', 'USR0012', 'SUP012', 'ST0000012',1,NULL),
('UC013', '2024-01-01', '2025-01-01', 'Pool Maintenance', 16000, 'Active', 'USR0013', 'SUP013', 'ST0000013',1,NULL),
('UC014', '2024-02-01', '2025-02-01', 'Snow Removal', 14000, 'Active', 'USR0014', 'SUP014', 'ST0000014',1,NULL),
('UC015', '2024-03-01', '2025-03-01', 'Emergency Services', 25000, 'Active', 'USR0015', 'SUP015', 'ST0000015',1,NULL),
('UC016', '2024-04-01', '2025-04-01', 'Inspection', 17000, 'Active', 'USR0016', 'SUP016', 'ST0000016',1,NULL),
('UC017', '2024-05-01', '2025-05-01', 'Fire Safety', 22000, 'Active', 'USR0017', 'SUP017', 'ST0000017',1,NULL),
('UC018', '2024-06-01', '2025-06-01', 'Electricity Audit', 14000, 'Active', 'USR0018', 'SUP018', 'ST0000018',1,NULL),
('UC019', '2024-07-01', '2025-07-01', 'Water Quality Check', 8000, 'Active', 'USR0019', 'SUP019', 'ST0000019',1,NULL),
('UC020', '2024-08-01', '2025-08-01', 'Gas Inspection', 15000, 'Active', 'USR0020', 'SUP020', 'ST0000020',1,NULL);

go
INSERT INTO employment_contract_ (id_, status_, name_, phone_, email_, id_user_, id_staff_, id_suppliers_,delete_status_,day_delete_)
VALUES
('EC001', 1, 'John Doe', 1234567890, 'john.doe@example.com', 'USR0001', 'ST0000030', 'SUP001',1,NULL),
('EC002', 1, 'Jane Smith', 9876543210, 'jane.smith@example.com', 'USR0002', 'ST0000010', 'SUP002',1,NULL),
('EC003', 1, 'Mike Johnson', 5551234567, 'mike.johnson@example.com', 'USR0003', 'ST0000030', 'SUP003',1,NULL),
('EC004', 1, 'Emily Davis', 4449876543, 'emily.davis@example.com', 'USR0004', 'ST0000030', 'SUP004',1,NULL),
('EC005', 1, 'James Brown', 6661239876, 'james.brown@example.com', 'USR0005', 'ST0000030', 'SUP005',1,NULL),
('EC006', 1, 'Olivia Wilson', 7776541230, 'olivia.wilson@example.com', 'USR0006', 'ST0000030', 'SUP006',1,NULL),
('EC007', 1, 'Daniel Moore', 8883216540, 'daniel.moore@example.com', 'USR0007', 'ST0000030', 'SUP007',1,NULL),
('EC008', 1, 'Sophia Taylor', 9999876540, 'sophia.taylor@example.com', 'USR0008', 'ST0000030', 'SUP008',1,NULL),
('EC009', 1, 'David Anderson', 4443219876, 'david.anderson@example.com', 'USR0009', 'ST0000030', 'SUP009',1,NULL),
('EC010', 1, 'Mia Martinez', 1236549870, 'mia.martinez@example.com', 'USR0010', 'ST0000030', 'SUP010',1,NULL),
('EC011', 1, 'Lucas Thomas', 9874561230, 'lucas.thomas@example.com', 'USR0011', 'ST0000030', 'SUP011',1,NULL),
('EC012', 1, 'Chloe Harris', 6543219876, 'chloe.harris@example.com', 'USR0012', 'ST0000030', 'SUP012',1,NULL),
('EC013', 1, 'Ethan Clark', 4321987654, 'ethan.clark@example.com', 'USR0013', 'ST0000030', 'SUP013',1,NULL),
('EC014', 1, 'Ava Lewis', 3214567890, 'ava.lewis@example.com', 'USR0014', 'ST0000030', 'SUP014',1,NULL),
('EC015', 1, 'Liam Lee', 5559871230, 'liam.lee@example.com', 'USR0015', 'ST0000030', 'SUP015',1,NULL),
('EC016', 1, 'Isabella Walker', 2224567890, 'isabella.walker@example.com', 'USR0016', 'ST0000030', 'SUP016',1,NULL),
('EC017', 1, 'Mason Hall', 1116543210, 'mason.hall@example.com', 'USR0017', 'ST0000030', 'SUP017',1,NULL),
('EC018', 1, 'Ella King', 9993214560, 'ella.king@example.com', 'USR0018', 'ST0000030', 'SUP018',1,NULL),
('EC019', 1, 'Noah Wright', 3339876540, 'noah.wright@example.com', 'USR0019', 'ST0000030', 'SUP019',1,NULL),
('EC020', 1, 'Harper Scott', 6666541230, 'harper.scott@example.com', 'USR0020', 'ST0000030', 'SUP020',1,NULL);

go
INSERT INTO technical_maintenance_ (id_, id_staff_send_, id_staff_action_, status_, name_, nearest_maintenance_, next_maintenance_, maintenance_task_, description_, floor_, id_equipment_,delete_status_,day_delete_)
VALUES
('MT001', 'ST0000001', 'ST0000001', 'Completed', 'Maintenance Task 1', '2024-01-10 08:30:00', '2024-06-10 08:30:00', 'Check air filters', 'Air filter replacement', 1, 'EQP001',1,NULL),
('MT002', 'ST0000002', 'ST0000002', 'In Progress', 'Maintenance Task 2', '2024-02-12 09:00:00', '2024-07-12 09:00:00', 'Inspect electrical wiring', 'Wiring inspection needed', 2, 'EQP002',1,NULL),
('MT003', 'ST0000003', 'ST0000003', 'Pending', 'Maintenance Task 3', '2024-03-15 10:00:00', '2024-08-15 10:00:00', 'Replace air conditioning filter', 'Scheduled for next month', 3, 'EQP003',1,NULL),
('MT004', 'ST0000004', 'ST0000004', 'Completed', 'Maintenance Task 4', '2024-04-18 11:30:00', '2024-09-18 11:30:00', 'Oil change', 'Engine oil replacement done', 4, 'EQP004',1,NULL),
('MT005', 'ST0000005', 'ST0000005', 'In Progress', 'Maintenance Task 5', '2024-05-20 12:45:00', '2024-10-20 12:45:00', 'Lubrication check', 'Ongoing lubrication check', 5, 'EQP005',1,NULL),
('MT006', 'ST0000006', 'ST0000006', 'Pending', 'Maintenance Task 6', '2024-06-22 14:00:00', '2024-11-22 14:00:00', 'Test generator output', 'Pending testing', 6, 'EQP006',1,NULL),
('MT007', 'ST0000007', 'ST0000007', 'Completed', 'Maintenance Task 7', '2024-07-25 15:15:00', '2024-12-25 15:15:00', 'Check water pressure', 'Pressure levels restored', 7, 'EQP007',1,NULL),
('MT008', 'ST0000008', 'ST0000008', 'In Progress', 'Maintenance Task 8', '2024-08-28 16:30:00', '2025-01-28 16:30:00', 'Inspect safety valves', 'Inspection in progress', 8, 'EQP008',1,NULL),
('MT009', 'ST0000009', 'ST0000009', 'Pendi', 'Maintenance ', '2024-10-10 10:10:10', '2024-02-20 9:9:9' , 'Replace safety sensors', 'Scheduled for replacement', 9, 'EQP009',1,NULL),
('MT010', 'ST0000008', 'ST0000008', 'Completed', 'Maintenance Task 10', '2024-10-02 08:00:00', '2025-03-02 08:00:00', 'Clean exhaust fans', 'Fans cleaned', 10, 'EQP010',1,NULL),
('MT011', 'ST0000007', 'ST0000007', 'In Progress', 'Maintenance Task 11', '2024-10-05 09:30:00', '2025-03-05 09:30:00', 'Test backup batteries', 'In progress', 11, 'EQP011',1,NULL),
('MT012', 'ST0000006', 'ST0000006', 'Pending', 'Maintenance Task 12', '2024-11-07 10:45:00', '2025-04-07 10:45:00', 'Inspect cooling systems', 'Pending inspection', 12, 'EQP012',1,NULL),
('MT013', 'ST0000005', 'ST0000005', 'Completed', 'Maintenance Task 13', '2024-12-10 11:30:00', '2025-05-10 11:30:00', 'Check fuel levels', 'Fuel levels optimized', 13, 'EQP013',1,NULL),
('MT014', 'ST0000004', 'ST0000004', 'In Progress', 'Maintenance Task 14', '2024-12-15 12:00:00', '2025-05-15 12:00:00', 'Inspect fire alarms', 'Alarm inspection ongoing', 14, 'EQP014',1,NULL),
('MT015', 'ST0000003', 'ST0000003', 'Pending', 'Maintenance Task 15', '2025-01-10 13:00:00', '2025-06-10 13:00:00', 'Test emergency lights', 'Lights need replacement', 15, 'EQP015',1,NULL),
('MT016', 'ST0000002', 'ST0000002', 'Completed', 'Maintenance Task 16', '2025-01-20 14:30:00', '2025-06-20 14:30:00', 'Replace door seals', 'Door seals replaced', 16, 'EQP016',1,NULL),
('MT017', 'ST0000001', 'ST0000001', 'In Progress', 'Maintenance Task 17', '2025-02-25 15:00:00', '2025-07-25 15:00:00', 'Check ventilation system', 'Ongoing', 17, 'EQP017',1,NULL),
('MT018', 'ST0000001', 'ST0000001', 'Pending', 'Maintenance Task 18', '2025-03-28 16:15:00', '2025-08-28 16:15:00', 'Inspect lighting system', 'Scheduled for inspection', 18, 'EQP018',1,NULL),
('MT019', 'ST0000001', 'ST0000001', 'Completed', 'Maintenance Task 19', '2025-04-30 17:30:00', '2025-09-30 17:30:00', 'Check elevator system', 'Elevator maintenance complete', 19, 'EQP019',1,NULL),
('MT020', 'ST0000001', 'ST0000001', 'In Progress', 'Maintenance Task 20', '2025-05-05 18:45:00', '2025-10-05 18:45:00', 'Inspect sprinkler system', 'Ongoing sprinkler inspection', 20, 'EQP020',1,NULL);

go
INSERT into technical_repair_(id_, id_staff_send_, id_staff_action_, status_, name_, nearest_repair_, next_repair_, repair_task_, description_, floor_, id_equipment_,delete_status_,day_delete_)
VALUES
('MT001', 'ST0000001', 'ST0000001', 'Completed', 'Maintenance Task 1', '2024-01-10 08:30:00', '2024-06-10 08:30:00', 'Check air filters', 'Air filter replacement', 1, 'EQP001',1,NULL),
('MT002', 'ST0000002', 'ST0000002', 'In Progress', 'Maintenance Task 2', '2024-02-12 09:00:00', '2024-07-12 09:00:00', 'Inspect electrical wiring', 'Wiring inspection needed', 2, 'EQP002',1,NULL),
('MT003', 'ST0000003', 'ST0000003', 'Pending', 'Maintenance Task 3', '2024-03-15 10:00:00', '2024-08-15 10:00:00', 'Replace air conditioning filter', 'Scheduled for next month', 3, 'EQP003',1,NULL),
('MT004', 'ST0000004', 'ST0000004', 'Completed', 'Maintenance Task 4', '2024-04-18 11:30:00', '2024-09-18 11:30:00', 'Oil change', 'Engine oil replacement done', 4, 'EQP004',1,NULL),
('MT005', 'ST0000005', 'ST0000005', 'In Progress', 'Maintenance Task 5', '2024-05-20 12:45:00', '2024-10-20 12:45:00', 'Lubrication check', 'Ongoing lubrication check', 5, 'EQP005',1,NULL),
('MT006', 'ST0000006', 'ST0000006', 'Pending', 'Maintenance Task 6', '2024-06-22 14:00:00', '2024-11-22 14:00:00', 'Test generator output', 'Pending testing', 6, 'EQP006',1,NULL),
('MT007', 'ST0000007', 'ST0000007', 'Completed', 'Maintenance Task 7', '2024-07-25 15:15:00', '2024-12-25 15:15:00', 'Check water pressure', 'Pressure levels restored', 7, 'EQP007',1,NULL),
('MT008', 'ST0000008', 'ST0000008', 'In Progress', 'Maintenance Task 8', '2024-08-28 16:30:00', '2025-01-28 16:30:00', 'Inspect safety valves', 'Inspection in progress', 8, 'EQP008',1,NULL),
('MT009', 'ST0000009', 'ST0000009', 'Pendi', 'Maintenance ', '2024-10-10 10:10:10', '2024-02-20 9:9:9' , 'Replace safety sensors', 'Scheduled for replacement', 9, 'EQP009',1,NULL),
('MT010', 'ST0000008', 'ST0000008', 'Completed', 'Maintenance Task 10', '2024-10-02 08:00:00', '2025-03-02 08:00:00', 'Clean exhaust fans', 'Fans cleaned', 10, 'EQP010',1,NULL),
('MT011', 'ST0000007', 'ST0000007', 'In Progress', 'Maintenance Task 11', '2024-10-05 09:30:00', '2025-03-05 09:30:00', 'Test backup batteries', 'In progress', 11, 'EQP011',1,NULL),
('MT012', 'ST0000006', 'ST0000006', 'Pending', 'Maintenance Task 12', '2024-11-07 10:45:00', '2025-04-07 10:45:00', 'Inspect cooling systems', 'Pending inspection', 12, 'EQP012',1,NULL),
('MT013', 'ST0000005', 'ST0000005', 'Completed', 'Maintenance Task 13', '2024-12-10 11:30:00', '2025-05-10 11:30:00', 'Check fuel levels', 'Fuel levels optimized', 13, 'EQP013',1,NULL),
('MT014', 'ST0000004', 'ST0000004', 'In Progress', 'Maintenance Task 14', '2024-12-15 12:00:00', '2025-05-15 12:00:00', 'Inspect fire alarms', 'Alarm inspection ongoing', 14, 'EQP014',1,NULL),
('MT015', 'ST0000003', 'ST0000003', 'Pending', 'Maintenance Task 15', '2025-01-10 13:00:00', '2025-06-10 13:00:00', 'Test emergency lights', 'Lights need replacement', 15, 'EQP015',1,NULL),
('MT016', 'ST0000002', 'ST0000002', 'Completed', 'Maintenance Task 16', '2025-01-20 14:30:00', '2025-06-20 14:30:00', 'Replace door seals', 'Door seals replaced', 16, 'EQP016',1,NULL),
('MT017', 'ST0000001', 'ST0000001', 'In Progress', 'Maintenance Task 17', '2025-02-25 15:00:00', '2025-07-25 15:00:00', 'Check ventilation system', 'Ongoing', 17, 'EQP017',1,NULL),
('MT018', 'ST0000001', 'ST0000001', 'Pending', 'Maintenance Task 18', '2025-03-28 16:15:00', '2025-08-28 16:15:00', 'Inspect lighting system', 'Scheduled for inspection', 18, 'EQP018',1,NULL),
('MT019', 'ST0000001', 'ST0000001', 'Completed', 'Maintenance Task 19', '2025-04-30 17:30:00', '2025-09-30 17:30:00', 'Check elevator system', 'Elevator maintenance complete', 19, 'EQP019',1,NULL),
('MT020', 'ST0000001', 'ST0000001', 'In Progress', 'Maintenance Task 20', '2025-05-05 18:45:00', '2025-10-05 18:45:00', 'Inspect sprinkler system', 'Ongoing sprinkler inspection', 20, 'EQP020',1,NULL);

go
INSERT INTO income_ (id_,id_user_, id_apartment_, status_,id_payment_method_,total_,payment_deadline_,id_type_income_,id_service_,delete_status_,day_delete_)
VALUES
('INC0001', 'USR0001', 'APM_001', 'Pending', 'tGQdMp0Kal', '1000', '2024-11-01', 'iDLCIOD34H', 'Q4zsZ37P3K',1,NULL),
('INC0002', 'USR0002', 'APM_002', 'Paid', 'LAT0MMpFe8', '1500', '2024-11-05', 'svelFQ4S2s', '4DDBfdJRhX',1,NULL),
('INC0003', 'USR0003', 'APM_003', 'Pending', 'rIi2FOJyFZ', '2000', '2024-11-10', 'pZb51pC2GO', 'pKg6dIj43p',1,NULL),
('INC0004', 'USR0004', 'APM_004', 'Paid', 'tGQdMp0Kal', '1200', '2024-11-15', 'iDLCIOD34H', 'Q4zsZ37P3K',1,NULL),
('INC0005', 'USR0005', 'APM_005', 'Pending', 'LAT0MMpFe8', '1800', '2024-11-20', 'svelFQ4S2s', '4DDBfdJRhX',1,NULL),
('INC0006', 'USR0006', 'APM_006', 'Paid', 'rIi2FOJyFZ', '2200', '2024-11-25', 'pZb51pC2GO', 'pKg6dIj43p',1,NULL),
('INC0007', 'USR0007', 'APM_007', 'Pending', 'tGQdMp0Kal', '1300', '2024-12-01', 'iDLCIOD34H', 'Q4zsZ37P3K',1,NULL),
('INC0008', 'USR0008', 'APM_008', 'Paid', 'LAT0MMpFe8', '1600', '2024-12-05', 'svelFQ4S2s', '4DDBfdJRhX',1,NULL),
('INC0009', 'USR0009', 'APM_009', 'Pending', 'rIi2FOJyFZ', '2500', '2024-12-10', 'pZb51pC2GO', 'pKg6dIj43p',1,NULL),
('INC0010', 'USR0010', 'APM_0010', 'Paid', 'tGQdMp0Kal', '1400', '2024-12-15', 'iDLCIOD34H', 'Q4zsZ37P3K',1,NULL),
('INC0011', 'USR0011', 'APM_0011', 'Pending', 'LAT0MMpFe8', '1700', '2024-12-20', 'svelFQ4S2s', '4DDBfdJRhX',1,NULL),
('INC0012', 'USR0012', 'APM_0012', 'Paid', 'rIi2FOJyFZ', '2300', '2024-12-25', 'pZb51pC2GO', 'pKg6dIj43p',1,NULL),
('INC0013', 'USR0013', 'APM_0013', 'Pending', 'tGQdMp0Kal', '1800', '2024-12-30', 'iDLCIOD34H', 'Q4zsZ37P3K',1,NULL),
('INC0014', 'USR0014', 'APM_0014', 'Paid', 'LAT0MMpFe8', '2400', '2025-01-05', 'svelFQ4S2s', '4DDBfdJRhX',1,NULL),
('INC0015', 'USR0015', 'APM_0015', 'Pending', 'rIi2FOJyFZ', '1900', '2025-01-10', 'pZb51pC2GO', 'pKg6dIj43p',1,NULL),
('INC0016', 'USR0016', 'APM_0016', 'Paid', 'tGQdMp0Kal', '2500', '2025-01-15', 'iDLCIOD34H', 'Q4zsZ37P3K',1,NULL),
('INC0017', 'USR0017', 'APM_0017', 'Pending', 'LAT0MMpFe8', '2000', '2025-01-20', 'svelFQ4S2s', '4DDBfdJRhX',1,NULL),
('INC0018', 'USR0018', 'APM_0018', 'Paid', 'rIi2FOJyFZ', '2600', '2025-01-25', 'pZb51pC2GO', 'pKg6dIj43p',1,NULL),
('INC0019', 'USR0019', 'APM_0019', 'Pending', 'tGQdMp0Kal', '2100', '2025-01-30', 'iDLCIOD34H', 'Q4zsZ37P3K',1,NULL),
('INC0020', 'USR0020', 'APM_0020', 'Paid', 'LAT0MMpFe8', '2700', '2025-02-05', 'svelFQ4S2s', '4DDBfdJRhX',1,NULL),
('INC0021', 'USR0001', 'APM_001', 'Pending', 'rIi2FOJyFZ', '2200', '2025-02-10', 'pZb51pC2GO', 'pKg6dIj43p',1,NULL),
('INC0022', 'USR0002', 'APM_002', 'Paid', 'tGQdMp0Kal', '2800', '2025-02-15', 'iDLCIOD34H', 'Q4zsZ37P3K',1,NULL),
('INC0023', 'USR0003', 'APM_003', 'Pending', 'LAT0MMpFe8', '2300', '2025-02-20', 'svelFQ4S2s', '4DDBfdJRhX',1,NULL),
('INC0024', 'USR0004', 'APM_004', 'Paid', 'rIi2FOJyFZ', '2900', '2025-02-25', 'pZb51pC2GO', 'pKg6dIj43p',1,NULL),
('INC0025', 'USR0005', 'APM_005', 'Pending', 'tGQdMp0Kal', '2400', '2025-03-01', 'iDLCIOD34H', 'Q4zsZ37P3K',1,NULL),
('INC0026', 'USR0006', 'APM_006', 'Paid', 'LAT0MMpFe8', '3000', '2025-03-05', 'svelFQ4S2s', '4DDBfdJRhX',1,NULL),
('INC0027', 'USR0007', 'APM_007', 'Pending', 'rIi2FOJyFZ', '2500', '2025-03-10', 'pZb51pC2GO', 'pKg6dIj43p',1,NULL),
('INC0028', 'USR0008', 'APM_008', 'Paid', 'tGQdMp0Kal', '3100', '2025-03-15', 'iDLCIOD34H', 'Q4zsZ37P3K',1,NULL),
('INC0029', 'USR0009', 'APM_009', 'Pending', 'LAT0MMpFe8', '2600', '2025-03-20', 'svelFQ4S2s', '4DDBfdJRhX',1,NULL),
('INC0030', 'USR0010', 'APM_0010', 'Paid', 'rIi2FOJyFZ', '3200', '2025-03-25', 'pZb51pC2GO', 'pKg6dIj43p',1,NULL),
('INC0031', 'USR0011', 'APM_0011', 'Pending', 'tGQdMp0Kal', '2700', '2025-03-30', 'iDLCIOD34H', 'Q4zsZ37P3K',1,NULL),
('INC0032', 'USR0012', 'APM_0012', 'Paid', 'LAT0MMpFe8', '3300', '2025-04-05', 'svelFQ4S2s', '4DDBfdJRhX',1,NULL),
('INC0033', 'USR0013', 'APM_0013', 'Pending', 'rIi2FOJyFZ', '2800', '2025-04-10', 'pZb51pC2GO', 'pKg6dIj43p',1,NULL),
('INC0034', 'USR0014', 'APM_0014', 'Paid', 'tGQdMp0Kal', '3400', '2025-04-15', 'iDLCIOD34H', 'Q4zsZ37P3K',1,NULL),
('INC0035', 'USR0015', 'APM_0015', 'Pending', 'LAT0MMpFe8', '2900', '2025-04-20', 'svelFQ4S2s', '4DDBfdJRhX',1,NULL),
('INC0036', 'USR0016', 'APM_0016', 'Paid', 'rIi2FOJyFZ', '3500', '2025-04-25', 'pZb51pC2GO', 'pKg6dIj43p',1,NULL),
('INC0037', 'USR0017', 'APM_0017', 'Pending', 'tGQdMp0Kal', '3000', '2025-04-30', 'iDLCIOD34H', 'Q4zsZ37P3K',1,NULL),
('INC0038', 'USR0018', 'APM_0018', 'Paid', 'LAT0MMpFe8', '3600', '2025-05-05', 'svelFQ4S2s', '4DDBfdJRhX',1,NULL),
('INC0039', 'USR0019', 'APM_0019', 'Pending', 'rIi2FOJyFZ', '3100', '2025-05-10', 'pZb51pC2GO', 'pKg6dIj43p',1,NULL),
('INC0040', 'USR0020', 'APM_0020', 'Paid', 'tGQdMp0Kal', '3700', '2025-05-15', 'iDLCIOD34H', 'Q4zsZ37P3K',1,NULL),
('INC0041', 'USR0001', 'APM_001', 'Pending', 'rIi2FOJyFZ', '2200', '2025-02-10', 'pZb51pC2GO', 'pKg6dIj43p',1,NULL),
('INC0042', 'USR0002', 'APM_002', 'Paid', 'tGQdMp0Kal', '2800', '2025-02-15', 'iDLCIOD34H', 'Q4zsZ37P3K',1,NULL),
('INC0043', 'USR0003', 'APM_003', 'Pending', 'LAT0MMpFe8', '2300', '2025-02-20', 'svelFQ4S2s', '4DDBfdJRhX',1,NULL),
('INC0044', 'USR0004', 'APM_004', 'Paid', 'rIi2FOJyFZ', '2900', '2025-02-25', 'pZb51pC2GO', 'pKg6dIj43p',1,NULL),
('INC0045', 'USR0005', 'APM_005', 'Pending', 'tGQdMp0Kal', '2400', '2025-03-01', 'iDLCIOD34H', 'Q4zsZ37P3K',1,NULL),
('INC0046', 'USR0006', 'APM_006', 'Paid', 'LAT0MMpFe8', '3000', '2025-03-05', 'svelFQ4S2s', '4DDBfdJRhX',1,NULL),
('INC0047', 'USR0007', 'APM_007', 'Pending', 'rIi2FOJyFZ', '2500', '2025-03-10', 'pZb51pC2GO', 'pKg6dIj43p',1,NULL),
('INC0048', 'USR0008', 'APM_008', 'Paid', 'tGQdMp0Kal', '3100', '2025-03-15', 'iDLCIOD34H', 'Q4zsZ37P3K',1,NULL),
('INC0049', 'USR0009', 'APM_009', 'Pending', 'LAT0MMpFe8', '2600', '2025-03-20', 'svelFQ4S2s', '4DDBfdJRhX',1,NULL),
('INC0050', 'USR0010', 'APM_0010', 'Paid', 'rIi2FOJyFZ', '3200', '2025-03-25', 'pZb51pC2GO', 'pKg6dIj43p',1,NULL),
('INC0051', 'USR0011', 'APM_0011', 'Pending', 'tGQdMp0Kal', '2700', '2025-03-30', 'iDLCIOD34H', 'Q4zsZ37P3K',1,NULL),
('INC0052', 'USR0012', 'APM_0012', 'Paid', 'LAT0MMpFe8', '3300', '2025-04-05', 'svelFQ4S2s', '4DDBfdJRhX',1,NULL),
('INC0053', 'USR0013', 'APM_0013', 'Pending', 'rIi2FOJyFZ', '2800', '2025-04-10', 'pZb51pC2GO', 'pKg6dIj43p',1,NULL),
('INC0054', 'USR0014', 'APM_0014', 'Paid', 'tGQdMp0Kal', '3400', '2025-04-15', 'iDLCIOD34H', 'Q4zsZ37P3K',1,NULL),
('INC0055', 'USR0015', 'APM_0015', 'Pending', 'LAT0MMpFe8', '2900', '2025-04-20', 'svelFQ4S2s', '4DDBfdJRhX',1,NULL),
('INC0056', 'USR0016', 'APM_0016', 'Paid', 'rIi2FOJyFZ', '3500', '2025-04-25', 'pZb51pC2GO', 'pKg6dIj43p',1,NULL),
('INC0057', 'USR0017', 'APM_0017', 'Pending', 'tGQdMp0Kal', '3000', '2025-04-30', 'iDLCIOD34H', 'Q4zsZ37P3K',1,NULL),
('INC0058', 'USR0018', 'APM_0018', 'Paid', 'LAT0MMpFe8', '3600', '2025-05-05', 'svelFQ4S2s', '4DDBfdJRhX',1,NULL),
('INC0059', 'USR0019', 'APM_0019', 'Pending', 'rIi2FOJyFZ', '3100', '2025-05-10', 'pZb51pC2GO', 'pKg6dIj43p',1,NULL),
('INC0060', 'USR0020', 'APM_0020', 'Paid', 'tGQdMp0Kal', '3700', '2025-05-15', 'iDLCIOD34H', 'Q4zsZ37P3K',1,NULL);

go 
INSERT INTO repair_history_ (id_, id_equiptment_, id_staff_, repair_maintenance_date_, price_, describe_,delete_status_,day_delete_)
VALUES 
('RP001', 'EQP001', 'ST0000001', '2024-01-01', 100.00, 'change eqipment EQP001',1,NULL),
('RP002', 'EQP002', 'ST0000002', '2024-01-02', 150.00, 'change eqipment EQP002',1,NULL),
('RP003', 'EQP003', 'ST0000003', '2024-01-03', 120.00, 'change eqipment EQP003',1,NULL),
('RP004', 'EQP004', 'ST0000004', '2024-01-04', 130.00, 'change eqipment EQP004',1,NULL),
('RP005', 'EQP005', 'ST0000005', '2024-01-05', 110.00, 'change eqipment EQP005',1,NULL),
('RP006', 'EQP006', 'ST0000006', '2024-01-06', 140.00, 'change eqipment EQP006',1,NULL),
('RP007', 'EQP007', 'ST0000007', '2024-01-07', 170.00, 'change eqipment EQP007',1,NULL),
('RP008', 'EQP008', 'ST0000008', '2024-01-08', 160.00, 'change eqipment EQP008',1,NULL),
('RP009', 'EQP009', 'ST0000009', '2024-01-09', 200.00, 'change eqipment EQP009',1,NULL),
('RP010', 'EQP010', 'ST0000010', '2024-01-10', 190.00, 'change eqipment EQP010',1,NULL),
('RP011', 'EQP011', 'ST0000011', '2024-01-11', 210.00, 'change eqipment EQP011',1,NULL),
('RP012', 'EQP012', 'ST0000012', '2024-01-12', 220.00, 'change eqipment EQP012',1,NULL),
('RP013', 'EQP013', 'ST0000013', '2024-01-13', 230.00, 'change eqipment EQP013',1,NULL),
('RP014', 'EQP014', 'ST0000014', '2024-01-14', 240.00, 'change eqipment EQP014',1,NULL),
('RP015', 'EQP015', 'ST0000015', '2024-01-15', 250.00, 'change eqipment EQP015',1,NULL),
('RP016', 'EQP016', 'ST0000016', '2024-01-16', 260.00, 'change eqipment EQP016',1,NULL),
('RP017', 'EQP017', 'ST0000017', '2024-01-17', 270.00, 'change eqipment EQP017',1,NULL),
('RP018', 'EQP018', 'ST0000018', '2024-01-18', 280.00, 'change eqipment EQP018',1,NULL),
('RP019', 'EQP019', 'ST0000019', '2024-01-19', 290.00, 'change eqipment EQP019',1,NULL),
('RP020', 'EQP020', 'ST0000020', '2024-01-20', 300.00, 'change eqipment EQP020',1,NULL);

go
INSERT INTO outcome_(id_,status_,name_service_,deription_,price_,id_type_outcome_,id_repair_history_,delete_status_,day_delete_)
VALUES
('OUT0001', 'Completed', 'Repair Service', 'Fixing air conditioning system', 500, 'R9YFawG2hn', 'RP001',1,NULL),
('OUT0002', 'In Progress', 'Maintenance Service', 'Regular maintenance of electrical systems', 300, 'skt6a561hH', 'RP002',1,NULL),
('OUT0003', 'Pending', 'Cleaning Service', 'Deep cleaning of the ventilation system', 200, 'R9YFawG2hn', 'RP003',1,NULL),
('OUT0004', 'Completed', 'Inspection Service', 'Inspection of plumbing and drainage', 150, 'skt6a561hH', 'RP004',1,NULL),
('OUT0005', 'In Progress', 'Repair Service', 'Fixing electrical wiring issues', 450, 'R9YFawG2hn', 'RP005',1,NULL),
('OUT0006', 'Pending', 'Replacement Service', 'Replacing faulty light fixtures', 250, 'skt6a561hH', 'RP006',1,NULL),
('OUT0007', 'Completed', 'Cleaning Service', 'Window and exterior cleaning', 350, 'R9YFawG2hn', 'RP007',1,NULL),
('OUT0008', 'In Progress', 'Maintenance Service', 'General building maintenance', 400, 'skt6a561hH', 'RP008',1,NULL),
('OUT0009', 'Pending', 'Repair Service', 'Fixing elevator issues', 600, 'R9YFawG2hn', 'RP009',1,NULL),
('OUT0010', 'Completed', 'Inspection Service', 'Safety inspection of fire alarms', 100, 'skt6a561hH', 'RP010',1,NULL),
('OUT0011', 'Pending', 'Repair Service', 'Fixing HVAC system issues', 550, 'R9YFawG2hn', 'RP011',1,NULL),
('OUT0012', 'Completed', 'Maintenance Service', 'Annual maintenance of fire extinguishers', 250, 'skt6a561hH', 'RP012',1,NULL),
('OUT0013', 'In Progress', 'Cleaning Service', 'Carpet cleaning and sanitation', 300, 'R9YFawG2hn', 'RP013',1,NULL),
('OUT0014', 'Pending', 'Inspection Service', 'Electrical system inspection', 180, 'skt6a561hH', 'RP014',1,NULL),
('OUT0015', 'Completed', 'Replacement Service', 'Replacing broken doors', 700, 'R9YFawG2hn', 'RP015',1,NULL),
('OUT0016', 'Pending', 'Repair Service', 'Fixing water leakage', 420, 'skt6a561hH', 'RP016',1,NULL),
('OUT0017', 'Completed', 'Cleaning Service', 'Sanitation of the common areas', 370, 'R9YFawG2hn', 'RP017',1,NULL),
('OUT0018', 'In Progress', 'Maintenance Service', 'Elevator maintenance and safety check', 500, 'skt6a561hH', 'RP018',1,NULL),
('OUT0019', 'Pending', 'Repair Service', 'Fixing lighting system issues', 320, 'R9YFawG2hn', 'RP019',1,NULL),
('OUT0020', 'Completed', 'Inspection Service', 'Structural safety inspection', 250, 'skt6a561hH', 'RP020',1,NULL);

go
INSERT INTO notification_staff_ (id_, id_user_, id_staff_, title_, deription_, notice_date_, sender_,delete_status_,day_delete_) 
VALUES
    ('NT0000001', 'USR0001', 'ST0000001', 'Rent Payment Notice', 
     'Please pay the rent before October 25, 2024.', '2024-10-13 08:00:00', 'Alice Johnson',1,NULL),
    ('NT0000002', 'USR0002', 'ST0000002', 'Repair Completion Report', 
     'The equipment was repaired on October 12, 2024.', '2024-10-13 09:00:00', 'Robert Smith',1,NULL),
    ('NT0000003', 'USR0003', 'ST0000003', 'Water System Maintenance', 
     'The water system will be maintained on October 15, 2024.', '2024-10-12 10:30:00', 'Charlie Evans',1,NULL),
    ('NT0000004', 'USR0004', 'ST0000004', 'Complaint Response', 
     'Your complaint has been received and will be processed within 3 working days.', '2024-10-11 14:00:00', 'Sophia Taylor',1,NULL),
    ('NT0000005', 'USR0005', 'ST0000005', 'New Service Request', 
     'A cleaning service has been scheduled for October 16, 2024.', '2024-10-11 15:30:00', 'David Brown',1,NULL),
    ('NT0000006', 'USR0006', 'ST0000006', 'September Invoice Notification', 
     'The September invoice has been sent to your email.', '2024-10-10 08:45:00', 'Emily Davis',1,NULL),
    ('NT0000007', 'USR0007', 'ST0000007', 'Additional Charges Notice', 
     'You have incurred additional fees due to late payment.', '2024-10-09 12:00:00', 'Michael Wilson',1,NULL),
    ('NT0000008', 'USR0008', 'ST0000008', 'Emergency Repair Notice', 
     'Please avoid using the elevator until further notice.', '2024-10-08 17:45:00', 'John Miller',1,NULL),
    ('NT0000009', 'USR0009', 'ST0000009', 'Electrical System Inspection', 
     'The electrical system will be inspected on October 20, 2024.', '2024-10-13 07:30:00', 'Emma Anderson',1,NULL),
    ('NT0000010', 'USR0010', 'ST0000010', 'Camera System Maintenance', 
     'The surveillance cameras will be offline temporarily on October 18, 2024.', '2024-10-12 16:00:00', 'Oliver Thomas',1,NULL),
    ('NT0000011', 'USR0011', 'ST0000011', 'Package Delivery Notice', 
     'Your package has arrived at the front desk.', '2024-10-12 12:30:00', 'Charlotte Martin',1,NULL),
    ('NT0000012', 'USR0012', 'ST0000012', 'Fire Drill Reminder', 
     'There will be a fire drill on October 21, 2024.', '2024-10-11 10:00:00', 'Benjamin Lee',1,NULL),
    ('NT0000013', 'USR0013', 'ST0000013', 'Community Event Invitation', 
     'You are invited to our community event on October 22, 2024.', '2024-10-13 11:00:00', 'Ella Walker',1,NULL),
    ('NT0000014', 'USR0014', 'ST0000014', 'Lease Renewal Notification', 
     'Your lease is due for renewal on November 1, 2024.', '2024-10-09 09:30:00', 'Lucas Allen',1,NULL),
    ('NT0000015', 'USR0015', 'ST0000015', 'Internet Downtime Notice', 
     'There will be an internet outage from 2 AM to 6 AM on October 14, 2024.', '2024-10-12 18:45:00', 'Matthew Cooper',1,NULL),
    ('NT0000016', 'USR0016', 'ST0000016', 'New Security Measures', 
     'Additional security measures will be implemented starting October 18, 2024.', '2024-10-08 15:00:00', 'Grace Adams',1,NULL),
	 ('NT0000017', 'USR0017', 'ST0000017', 'Annual Inspection Schedule', 
     'The annual inspection is scheduled for October 25, 2024.', '2024-10-07 08:00:00', 'William Nelson',1,NULL),
    ('NT0000018', 'USR0018', 'ST0000018', 'Parking Policy Update', 
     'New parking policies will be effective from October 30, 2024.', '2024-10-13 08:00:00', 'Anthony Murphy',1,NULL),
    ('NT0000019', 'USR0019', 'ST0000019', 'Lost and Found Notification', 
     'A lost item matching your description has been found.', '2024-10-06 13:00:00', 'Victoria Carter',1,NULL),
    ('NT0000020', 'USR0020', 'ST0000020', 'Visitor Registration Update', 
     'Please register visitors in advance through the online portal.', '2024-10-12 10:30:00', 'Amelia Young',1,NULL);

go
INSERT INTO maintenance_repair_ (id_, id_user_, id_apartment_, expected_completion_date_, repair_content_, condition_of_damage_, id_equipment_,delete_status_,day_delete_)
VALUES
('MR001', 'USR0001', 'APM_001', '2024-11-15', 'Fix air conditioner', 'Leaking refrigerant', 'EQP001',1,NULL),
('MR002', 'USR0002', 'APM_002', '2024-11-20', 'Repair elevator', 'Stuck between floors', 'EQP002',1,NULL),
('MR003', 'USR0003', 'APM_003', '2024-11-25', 'Replace generator battery', 'Battery low voltage', 'EQP003',1,NULL),
('MR004', 'USR0004', 'APM_004', '2024-12-01', 'Fix water heater', 'No hot water', 'EQP004',1,NULL),
('MR005', 'USR0005', 'APM_005', '2024-12-05', 'Repair fire alarm system', 'Faulty sensor', 'EQP005',1,NULL),
('MR006', 'USR0006', 'APM_006', '2024-12-10', 'Replace security camera', 'Broken lens', 'EQP006',1,NULL),
('MR007', 'USR0007', 'APM_007', '2024-12-15', 'Repair air ventilation system', 'Low airflow', 'EQP007',1,NULL),
('MR008', 'USR0008', 'APM_008', '2024-12-20', 'Fix electric fence', 'No power', 'EQP008',1,NULL),
('MR009', 'USR0009', 'APM_009', '2024-12-25', 'Repair sprinkler system', 'Water pressure low', 'EQP009',1,NULL),
('MR010', 'USR0010', 'APM_0010', '2025-01-05', 'Replace backup generator', 'Frequent power failure', 'EQP010',1,NULL),
('MR011', 'USR0011', 'APM_0011', '2025-01-10', 'Fix lighting system', 'Flickering lights', 'EQP011',1,NULL),
('MR012', 'USR0012', 'APM_0012', '2025-01-15', 'Repair fire extinguisher', 'Low pressure', 'EQP012',1,NULL),
('MR013', 'USR0013', 'APM_0013', '2025-01-20', 'Fix CCTV camera', 'No video feed', 'EQP013',1,NULL),
('MR014', 'USR0014', 'APM_0014', '2025-01-25', 'Replace access control system', 'Card reader malfunction', 'EQP014',1,NULL),
('MR015', 'USR0015', 'APM_0015', '2025-02-01', 'Repair elevator panel', 'Buttons not working', 'EQP015',1,NULL),
('MR016', 'USR0016', 'APM_0016', '2025-02-05', 'Fix water pump', 'No water flow', 'EQP016',1,NULL),
('MR017', 'USR0017', 'APM_0017', '2025-02-10', 'Replace heat detector', 'False alarms', 'EQP017',1,NULL),
('MR018', 'USR0018', 'APM_0018', '2025-02-15', 'Repair ventilation fan', 'Overheating', 'EQP018',1,NULL),
('MR019', 'USR0019', 'APM_0019', '2025-02-20', 'Fix fire exit door', 'Does not close properly', 'EQP019',1,NULL),
('MR020', 'USR0020', 'APM_0020', '2025-02-25', 'Repair smoke detector', 'No response to smoke', 'EQP020',1,NULL);

go
INSERT INTO schedule_a_home_inspection_(id_, id_apartment_, name_, phone_, date_, status_,delete_status_,day_delete_)
VALUES
('INS0001', 'APM_001', 'John Doe', '123-456-7890', '2024-10-15 10:00:00', 'Pending',1,NULL),
('INS0002', 'APM_002', 'Jane Smith', '987-654-3210', '2024-10-16 14:30:00', 'Confirmed',1,NULL),
('INS0003', 'APM_003', 'Michael Johnson', '555-123-4567', '2024-10-17 09:00:00', 'Completed',1,NULL),
('INS0004', 'APM_004', 'Emily Davis', '444-222-3333', '2024-10-18 11:00:00', 'Canceled',1,NULL),
('INS0005', 'APM_005', 'David Brown', '777-888-9999', '2024-10-19 15:00:00', 'Pending',1,NULL),
('INS0006', 'APM_006', 'Sophia Martinez', '111-222-3333', '2024-10-20 12:00:00', 'Confirmed',1,NULL),
('INS0007', 'APM_007', 'Chris Lee', '222-333-4444', '2024-10-21 08:30:00', 'Completed',1,NULL),
('INS0008', 'APM_008', 'Natalie Harris', '333-444-5555', '2024-10-22 13:00:00', 'Pending',1,NULL),
('INS0009', 'APM_009', 'Paul White', '444-555-6666', '2024-10-23 16:00:00', 'Canceled',1,NULL),
('INS0010', 'APM_0010', 'Anna Thompson', '555-666-7777', '2024-10-24 10:30:00', 'Confirmed',1,NULL),
('INS0011', 'APM_0011', 'Ethan Garcia', '666-777-8888', '2024-10-25 11:45:00', 'Completed',1,NULL),
('INS0012', 'APM_0012', 'Zoe Wilson', '777-888-9990', '2024-10-26 14:15:00', 'Pending',1,NULL),
('INS0013', 'APM_0013', 'Oliver Clark', '888-999-0001', '2024-10-27 15:30:00', 'Confirmed',1,NULL),
('INS0014', 'APM_0014', 'Amelia Lewis', '999-000-1111', '2024-10-28 12:30:00', 'Completed',1,NULL),
('INS0015', 'APM_0015', 'Lucas Walker', '111-222-3330', '2024-10-29 09:15:00', 'Canceled',1,NULL),
('INS0016', 'APM_0016', 'Mia Hall', '222-333-4440', '2024-10-30 14:45:00', 'Pending',1,NULL),
('INS0017', 'APM_0017', 'James Allen', '333-444-5550', '2024-11-01 11:30:00', 'Confirmed',1,NULL),
('INS0018', 'APM_0018', 'Lily Young', '444-555-6660', '2024-11-02 16:45:00', 'Completed',1,NULL),
('INS0019', 'APM_0019', 'William King', '555-666-7770', '2024-11-03 13:30:00', 'Pending',1,NULL),
('INS0020', 'APM_0020', 'Ava Wright', '666-777-8880', '2024-11-04 12:15:00', 'Confirmed',1,NULL);

go
INSERT INTO payment_ (id_, user_id_, id_service_, id_income_, status_, total_, payment_Dateline_, id_payment_method_,delete_status_,day_delete_)
VALUES ('PM001', 'USR0001',  'Q4zsZ37P3K', 'INC0001', 'complete', 15000, '2024-12-31', 'tGQdMp0Kal',1,NULL),
       ('PM002', 'USR0002',  '4DDBfdJRhX', 'INC0002', 'unfinished', 20000, '2025-01-31', 'tGQdMp0Kal',1,NULL),
   ('PM003', 'USR0003',  'pKg6dIj43p', 'INC0003', 'unfinished', 10000, '2025-02-28', 'tGQdMp0Kal',1,NULL),
   ('PM004', 'USR0004',  '4DDBfdJRhX', 'INC0004', 'unfinished', 25000, '2025-03-31', 'tGQdMp0Kal',1,NULL),
   ('PM005', 'USR0005',  'Q4zsZ37P3K', 'INC0005', 'unfinished', 10000, '2025-04-30', 'tGQdMp0Kal',1,NULL),
   ('PM006', 'USR0006',  'pKg6dIj43p', 'INC0006', 'unfinished', 15000, '2025-05-31', 'tGQdMp0Kal',1,NULL),
   ('PM007', 'USR0007',  'Q4zsZ37P3K', 'INC0007', 'unfinished', 20000, '2025-06-30', 'tGQdMp0Kal',1,NULL),
   ('PM008', 'USR0008',  '4DDBfdJRhX', 'INC0008', 'unfinished', 5000, '2025-07-31', 'tGQdMp0Kal',1,NULL),
   ('PM009', 'USR0009',  'pKg6dIj43p', 'INC0009', 'unfinished', 25000, '2025-08-31', 'tGQdMp0Kal',1,NULL),
   ('PM010', 'USR0010', 'Q4zsZ37P3K', 'INC0010', 'unfinished', 10000, '2025-09-30', 'tGQdMp0Kal',1,NULL),
   ('PM011', 'USR0011',  '4DDBfdJRhX', 'INC0011', 'unfinished', 12000, '2025-10-31', 'tGQdMp0Kal',1,NULL),
   ('PM012', 'USR0012',  'pKg6dIj43p', 'INC0012', 'unfinished', 30000, '2025-11-30', 'tGQdMp0Kal',1,NULL),
   ('PM013', 'USR0013',  '4DDBfdJRhX', 'INC0013', 'unfinished', 5000, '2025-12-31', 'tGQdMp0Kal',1,NULL),
   ('PM014', 'USR0014',  'pKg6dIj43p', 'INC0014', 'unfinished', 10000, '2026-01-31', 'tGQdMp0Kal',1,NULL),
   ('PM015', 'USR0015',  'Q4zsZ37P3K', 'INC0015', 'unfinished', 20000, '2026-02-28', 'tGQdMp0Kal',1,NULL),
   ('PM016', 'USR0016',  'Q4zsZ37P3K', 'INC0016', 'unfinished', 25000, '2026-03-31', 'tGQdMp0Kal',1,NULL),
   ('PM017', 'USR0017',  'pKg6dIj43p', 'INC0017', 'unfinished', 10000, '2026-04-30', 'tGQdMp0Kal',1,NULL),
   ('PM018', 'USR0018',  'Q4zsZ37P3K', 'INC0018', 'unfinished', 10000, '2026-05-31', 'tGQdMp0Kal',1,NULL),
   ('PM019', 'USR0019',  '4DDBfdJRhX', 'INC0019', 'unfinished', 20000, '2026-06-30', 'tGQdMp0Kal',1,NULL),
   ('PM020', 'USR0020',  'Q4zsZ37P3K', 'INC0020', 'unfinished', 15000, '2026-07-31', 'tGQdMp0Kal',1,NULL);

go 
INSERT INTO rental_request_(id_, id_apartment_, tenant_name_, date_of_birth_, address_, phone_, email_, job_, status_,delete_status_,day_delete_)
VALUES
('REQ0001', 'APM_001', 'John Doe',  '1990-10-15 10:00:00', 'Alaska','123-456-7890', 'Johndoe@gmail.com', 'Doctor', 'Pending',1,NULL),
('REQ0002', 'APM_002', 'Jane Smith',  '1989-10-16 14:30:00', 'Georgia', '987-654-3210', 'Janesmith@gmail.com', 'Data processor', 'Confirmed',1,NULL),
('REQ0003', 'APM_003', 'Michael Johnson',  '1992-10-17 09:00:00', 'Arizona','555-123-4567', 'Michaeljohnson@gmail.com','Interior designer', 'Completed',1,NULL),
('REQ0004', 'APM_004', 'Emily Davis',  '1993-10-18 11:00:00', 'Washington', '444-222-3333', 'Emilydavis@gmail.com','Lecturer', 'Canceled',1,NULL),
('REQ0005', 'APM_005', 'David Brown',  '1992-10-19 15:00:00', 'California','777-888-9999', 'Davidbrown@gmail.com','Auditor', 'Pending',1,NULL),
('REQ0006', 'APM_006', 'Sophia Martinez',  '1996-10-20 12:00:00', 'Alaska', '111-222-3333', 'Sophiamartinez@gmail.com','Designer','Confirmed',1,NULL),
('REQ0007', 'APM_007', 'Chris Lee',  '1970-10-21 08:30:00','Georgia', '222-333-4444', 'Chrislee@gmail.com','Engineer','Completed',1,NULL),
('REQ0008', 'APM_008', 'Natalie Harris',  '1985-10-22 13:00:00', 'California', '333-444-5555', 'Natalieharris@gmail.com','Interior designer', 'Pending',1,NULL),
('REQ0009', 'APM_009', 'Paul White',  '1989-10-23 16:00:00', 'Arizona', '444-555-6666', 'Paulwhite@gmail.com', 'Salesperson', 'Canceled',1,NULL),
('REQ0010', 'APM_0010', 'Anna Thompson', '1995-10-24 10:30:00', 'Washington', '555-666-7777', 'Annathompson@gmail.com', 'Camera operator', 'Confirmed',1,NULL),
('REQ0011', 'APM_0011', 'Ethan Garcia', '1997-10-25 11:45:00','Georgia', '666-777-8888', 'Ethangarcia@gmail.com', 'Doctor', 'Completed',1,NULL),
('REQ0012', 'APM_0012', 'Zoe Wilson', '1991-10-26 14:15:00', 'Alaska', '777-888-9990', 'Zoewilson@gmail.com', 'Engineer', 'Pending',1,NULL),
('REQ0013', 'APM_0013', 'Oliver Clark', '1991-10-27 15:30:00', 'Washington', '888-999-0001', 'Oliverclark@gmail.com', 'Auditor', 'Confirmed',1,NULL),
('REQ0014', 'APM_0014', 'Amelia Lewis', '1997-10-28 12:30:00', 'Arizona', '999-000-1111', 'Amelialewis@gmail.com', 'Designer', 'Completed',1,NULL),
('REQ0015', 'APM_0015', 'Lucas Walker', '1989-10-29 09:15:00', 'California',  '111-222-3330', 'Lucaswalker@gmail.com', 'Salesperson', 'Canceled',1,NULL),
('REQ0016', 'APM_0016', 'Mia Hall', '1990-10-30 14:45:00', 'Washington', '222-333-4440', 'Miahall@gmail.com', 'Pilot', 'Pending',1,NULL),
('REQ0017', 'APM_0017', 'James Allen', '1998-11-01 11:30:00', 'Alaska', '333-444-5550', 'Jamesallen@gmail.com', 'Doctor', 'Confirmed',1,NULL),
('REQ0018', 'APM_0018', 'Lily Young', '2000-11-02 16:45:00', 'Washington', '444-555-6660', 'Lilyyoung@gmail.com', 'Model', 'Completed',1,NULL),
('REQ0019', 'APM_0019', 'William King', '1999-11-03 13:30:00','Georgia', '555-666-7770', 'Williamking@gmail.com', 'Lecturer', 'Pending',1,NULL),
('REQ0020', 'APM_0020', 'Ava Wright', '2001-11-04 12:15:00', 'Arizona', '666-777-8880', 'Avawright@gmail.com', 'Data processor', 'Confirmed',1,NULL);

go
INSERT INTO complaints_(id_, id_apartment_, id_user_, complaint_date_,expected_completion_date_,content_of_complaint_,proof_img_,id_staff_,note_, status_,delete_status_,day_delete_)
VALUES
(1, 'APM_001','USR0001','2023-10-10','2023-10-20', 'Product Defect',NULL,'ST0000001', 'The product malfunctioned within two days.', 'Pending',1,NULL),
(2, 'APM_002','USR0002','2023-1-10','2023-1-20', 'Late Delivery',NULL,'ST0000001', 'The package arrived three days later than expected.', 'Pending',1,NULL),
(3, 'APM_003','USR0001','2023-9-10','2023-10-10', 'Rude Staff',NULL,'ST0000001', 'The delivery person was impolite.', 'Resolved',1,NULL),
(4, 'APM_003','USR0002','2023-1-10','2023-1-15', 'Website Issue',NULL,'ST0000001', 'Unable to complete payment due to site error.', 'Pending',1,NULL),
(5, 'APM_004','USR0003','2024-10-10','2024-10-15', 'Wrong Product',NULL,'ST0000001', 'Received a different item than what I ordered.', 'Pending',1,NULL),
(6, 'APM_005','USR0003','2024-1-1','2024-1-10', 'Damaged Packaging',NULL,'ST0000001', 'The package was torn, and the product scratched.', 'Rejected',1,NULL),
(7, 'APM_001','USR0004','2023-1-15','2023-1-20', 'Customer Support Delay',NULL,'ST0000001', 'No response from support for 5 days.', 'Pending',1,NULL),
(8, 'APM_006','USR0005','2024-3-10','2023-4-10', 'Refund Delay',NULL,'ST0000001', 'Refund process took longer than 10 days.', 'Resolved',1,NULL),
(9, 'APM_007','USR0007','2023-3-15','2023-4-1', 'Broken Product',NULL,'ST0000001', 'The pet toy broke within minutes.', 'Pending',1,NULL),
(10, 'APM_0010','USR0010','2024-1-25','2024-2-4', 'Promotion Code Not Applied',NULL,'ST0000001', 'Discount code did not work during checkout.', 'Resolved',1,NULL),
(11, 'APM_008','USR0008','2023-12-10','2023-12-20', 'Missing Items',NULL,'ST0000001', 'Some items were missing from my order.', 'Resolved',1,NULL),
(12, 'APM_009','USR0009','2023-5-10','2023-5-20', 'Unauthorized Cancellation',NULL,'ST0000001', 'Order was canceled without notice.', 'Rejected',1,NULL),
(13, 'APM_0010','USR0010','2023-6-10','2023-7-10', 'Duplicate Payment',NULL,'ST0000001', 'Charged twice for the same order.', 'Resolved',1,NULL),
(14, 'APM_0010','USR0010','2023-6-18','2023-6-25', 'Expired Product',NULL,'ST0000001', 'Received a product that expired last month.', 'Resolved',1,NULL),
(15, 'APM_0011','USR0011','2023-10-10','2023-10-20', 'Overcharging',NULL,'ST0000001', 'Charged more than the listed price.', 'Resolved',1,NULL),
(16, 'APM_0012','USR0012','2023-3-10','2023-3-15', 'Wrong Quantity',NULL,'ST0000001', 'Ordered 3 units but received only 2.', 'Pending',1,NULL),
(17, 'APM_0010','USR0010','2023-8-10','2023-8-20', 'Unhelpful Chat Support',NULL,'ST0000001', 'Chat support gave irrelevant answers.', 'Pending',1,NULL),
(18, 'APM_0013','USR0013','2023-9-10','2023-9-20', 'Allergic Reaction',NULL,'ST0000001', 'Pet had an allergic reaction to the food.', 'Resolved',1,NULL),
(19, 'APM_0010','USR0010','2023-12-31','2024-1-10', 'Login Issues',NULL,'ST0000001', 'Unable to log into my account.', 'Pending',1,NULL),
(20, 'APM_0014','USR0014','2024-1-10','2023-1-20', 'Slow Shipping',NULL,'ST0000001', 'Delivery took much longer than promised.', 'Pending',1,NULL),
(21, 'APM_0015','USR0015','2022-10-10','2022-10-20', 'Incorrect Invoice',NULL,'ST0000001', 'Invoice contains incorrect billing details.', 'Resolved',1,NULL),
(22, 'APM_0010','USR0010','2024-1-10','2024-1-30', 'App Crash',NULL,'ST0000001', 'App crashed during order placement.', 'Pending',1,NULL),
(23, 'APM_0016','USR0016','2023-10-10','2023-10-20', 'Unauthorized Charges',NULL,'ST0000001', 'Detected charges I didn�t make.', 'Rejected',1,NULL),
(24, 'APM_0017','USR0017','2023-1-15','2023-2-3', 'Return Rejected',NULL,'ST0000001', 'Return request was denied without reason.', 'Pending',1,NULL),
(25, 'APM_0018','USR0018','2023-1-2','2023-2-3', 'Lost Package',NULL,'ST0000001', 'The order was marked as delivered but never arrived.', 'Pending',1,NULL);
