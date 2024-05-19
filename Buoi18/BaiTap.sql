CREATE DATABASE company;

USE company;

CREATE TABLE employees (
    employee_id INT,
    employee_name VARCHAR(255),
    salary DECIMAL(10, 2),
    start_date DATE,
    department_id INT,
    PRIMARY KEY(employee_id)
);

CREATE TABLE access_rights (
    access_id INT,
    employee_id INT,
    access_level VARCHAR(255),
    PRIMARY KEY(access_id),
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);

CREATE TABLE departments (
    department_id INT,
    department_name VARCHAR(255),
    PRIMARY KEY(department_id)
);

INSERT INTO employees (employee_id, employee_name, salary, start_date, department_id)
VALUES
    (1, 'John Doe', 60000, '2021-01-15', 1),
    (2, 'Jane Smith', 70000, '2020-05-20', 2),
    (3, 'Bob Johnson', 55000, '2022-03-10', 1),
    (4, 'Alice Williams', 80000, '2021-08-05', 3),
    (5, 'Charlie Brown', 65000, '2020-12-01', 2);
      

INSERT INTO departments (department_id, department_name)
VALUES
    (1, 'IT'),
    (2, 'Sales'),
    (3, 'HR');
   
INSERT INTO departments (department_id, department_name)
VALUES (4, 'ThuKy');


INSERT INTO access_rights (access_id, employee_id, access_level)
VALUES
    (1, 1, 'Admin'),
    (2, 2, 'User'),
    (3, 3, 'User'),
    (4, 4, 'Admin'),
    (5, 5, 'User');

   
-- Hiển thị tất cả thông tin của bảng "employees"
  SELECT * FROM employees e;
  
-- Hiển thị tên và lương của tất cả nhân viên
  SELECT e.employee_name , e.salary 
  FROM employees e;
 
--  Hiển thị thông tin của những nhân viên có lương lớn hơn 50000
 SELECT *
 FROM employees e
 WHERE e.salary > 50000;

-- Hiển thị số lượng nhân viên trong mỗi phòng ban
SELECT d.department_name, COUNT(e.employee_id) AS so_nhanvien  
FROM departments d
LEFT JOIN employees e  ON d.department_id = e.department_id 
GROUP BY d.department_name;


-- Sắp xếp danh sách nhân viên theo tên từ A-Z
SELECT *
FROM employees e 
ORDER BY e.employee_name ASC;

-- Hiển thị tên, lương và phòng ban của những nhân viên có lương từ 40000 đến 60000, sắp xếp theo lương giảm dần
SELECT e.employee_name, e.salary, d.department_name 
FROM employees e 
JOIN departments d ON e.department_id = d.department_id 
WHERE e.salary >= 40000 AND e.salary <= 60000
ORDER BY e.salary DESC;

-- Tính tổng lương của tất cả nhân viên
SELECT SUM(e.salary) AS tongluong_nhanvien
FROM employees e;

-- Hiển thị tên của nhân viên và tên phòng ban của họ
SELECT e.employee_name, d.department_name 
FROM employees e
JOIN departments d ON e.department_id = d.department_id;


-- Tìm những phòng ban có ít nhất 3 nhân viên
SELECT d.department_name, COUNT(*) AS so_nhanvien  
FROM employees e
JOIN departments d ON d.department_id = e.department_id 
GROUP BY d.department_name
HAVING so_nhanvien >= 3;

-- Hiển thị tên nhân viên và lương của những nhân viên ở phòng ban "IT" hoặc "Sales"
SELECT e.employee_name, d.department_name , e.salary 
FROM employees e
JOIN departments d ON d.department_id = e.department_id
WHERE e.department_id = 1 OR e.department_id = 2;

-- Hiển thị tên và ngày bắt đầu làm việc của những nhân viên được tuyển dụng sau năm 2020
SELECT e.employee_name, e.start_date
FROM employees e 
WHERE DATE_FORMAT(e.start_date , '%Y') > 2020;

-- Tính trung bình lương của nhân viên
SELECT AVG(e.salary) AS LuongTrungBinh
FROM employees e;

-- Hiển thị danh sách các phòng ban và số lượng nhân viên trong mỗi phòng ban, kể cả những phòng ban không có nhân viên
SELECT d.department_name, COUNT(e.employee_id) AS so_nhanvien 
FROM departments d 
LEFT JOIN employees e ON d.department_id = e.department_id
GROUP BY d.department_name;

-- Hiển thị 5 nhân viên có lương cao nhất
SELECT * 
FROM employees e
ORDER BY e.salary DESC
LIMIT 5;

-- Tìm những nhân viên có tên bắt đầu bằng chữ "A"
SELECT *
FROM employees e 
WHERE e.employee_name REGEXP '^A';

-- Hiển thị tên nhân viên và tên quyền truy cập của những người có quyền là "Admin"
SELECT e.employee_name, ar.access_level 
FROM employees e 
JOIN access_rights ar ON ar.employee_id = e.employee_id AND ar.access_level = "Admin";

-- Tính tổng lương cho mỗi phòng ban và sắp xếp theo tổng lương giảm dần
SELECT d.department_name, SUM(e.salary) AS tongluong 
FROM departments d 
LEFT JOIN employees e ON d.department_id = e.department_id
GROUP BY d.department_name
ORDER BY tongluong DESC;

-- Hiển thị danh sách nhân viên và ngày bắt đầu làm việc, sắp xếp theo ngày bắt đầu làm việc tăng dần
SELECT *
FROM employees e
ORDER BY e.start_date ASC;

-- Tìm những nhân viên có lương cao nhất trong từng phòng ban
SELECT d.department_name, MAX(e.salary) AS luong_caonhat
FROM departments d 
LEFT JOIN employees e ON d.department_id = e.department_id
GROUP BY d.department_name;

-- Hiển thị danh sách nhân viên và tên quyền truy cập của họ, bao gồm những nhân viên không có quyền truy cập
SELECT e.employee_name, ar.access_level 
FROM employees e 
LEFT JOIN access_rights ar ON e.employee_id = ar.employee_id;


