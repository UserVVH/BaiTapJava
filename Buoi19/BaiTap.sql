CREATE DATABASE company;

USE company;


CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    name VARCHAR(100),
    department_id INT,
    manager_id INT,
    salary DECIMAL(10, 2)
);

INSERT INTO employees (employee_id, name, department_id, manager_id, salary) VALUES
(1, 'Alice', 1, NULL, 60000),
(2, 'Bob', 1, 1, 55000),
(3, 'Charlie', 2, 1, 70000),
(4, 'David', 2, 3, 65000),
(5, 'Eve', 3, 1, 62000),
(6, 'Frank', 3, 5, 58000),
(7, 'Grace', 4, 1, 72000),
(8, 'Heidi', 4, 7, 71000),
(9, 'Ivan', 5, 1, 75000),
(10, 'Judy', 5, 9, 68000);


CREATE TABLE departments (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(100)
);

INSERT INTO departments (department_id, department_name) VALUES
(1, 'HR'),
(2, 'Engineering'),
(3, 'Marketing'),
(4, 'Sales'),
(5, 'Finance');

CREATE TABLE projects (
    project_id INT PRIMARY KEY,
    project_name VARCHAR(100),
    department_id INT
);

INSERT INTO projects (project_id, project_name, department_id) VALUES
(1, 'Project A', 1),
(2, 'Project B', 2),
(3, 'Project C', 2),
(4, 'Project D', 3),
(5, 'Project E', 4),
(6, 'Project F', 5),
(7, 'Project G', 1),
(8, 'Project H', 3),
(9, 'Project I', 4),
(10, 'Project J', 5);

CREATE TABLE employee_projects (
    employee_id INT,
    project_id INT,
    PRIMARY KEY (employee_id, project_id)
);

INSERT INTO employee_projects (employee_id, project_id) VALUES
(1, 1),
(1, 7),
(2, 1),
(3, 2),
(3, 3),
(4, 2),
(4, 3),
(5, 4),
(5, 8),
(6, 4),
(6, 8),
(7, 5),
(7, 9),
(8, 5),
(8, 9),
(9, 6),
(9, 10),
(10, 6),
(10, 10);

-- Liệt kê tên nhân viên và tên phòng ban của họ
SELECT e.name, d.department_name 
FROM employees e
JOIN departments d ON e.department_id = d.department_id;

-- Liệt kê tên nhân viên và tên dự án mà họ tham gia
SELECT e.name, p.project_name 
FROM employees e
JOIN employee_projects ep ON e.employee_id = ep.employee_id
JOIN projects p ON ep.project_id = p.project_id;

-- Liệt kê tên phòng ban, tên dự án và tên nhân viên tham gia dự án đó
SELECT d.department_name, p.project_name, e.name  
FROM departments d 
JOIN projects p ON d.department_id  = p.department_id
JOIN employee_projects ep ON p.project_id = ep.project_id
JOIN employees e ON ep.employee_id = e.employee_id;

-- Tính tổng lương của nhân viên tham gia từng dự án
SELECT p.project_name, SUM(e.salary) AS tong_luong 
FROM projects p 
JOIN employee_projects ep ON p.project_id =  ep.project_id
JOIN employees e ON ep.employee_id = e.employee_id
GROUP BY p.project_name;

-- Liệt kê tên nhân viên, tên quản lý của họ và tên dự án họ tham gia
SELECT 
    e.name AS 'Employee Name', 
    m.name AS 'Manager Name', 
    p.project_name AS 'Project Name'
FROM 
    employees e
LEFT JOIN employees m ON e.manager_id = m.employee_id
JOIN employee_projects ep ON e.employee_id = ep.employee_id
JOIN projects p ON ep.project_id = p.project_id;

-- Liệt kê tên phòng ban và số lượng nhân viên tham gia dự án của từng phòng ban
SELECT d.department_name, COUNT(ep.employee_id) AS so_nhanvien
FROM departments d
JOIN projects p ON d.department_id = p.department_id
JOIN employee_projects ep ON p.project_id =  ep.project_id
GROUP BY d.department_name;

-- Tìm tên nhân viên, tên dự án có lương cao nhất tham gia trong mỗi dự án
SELECT e.name, p.project_name, e.salary
FROM employees e
JOIN employee_projects ep ON e.employee_id = ep.employee_id
JOIN projects p ON ep.project_id = p.project_id
WHERE e.salary = (
	SELECT MAX(e.salary)
	FROM employees e
	JOIN employee_projects ep ON e.employee_id = ep.employee_id
);

-- Liệt kê tên dự án và tổng số nhân viên tham gia, sắp xếp theo tổng số nhân viên giảm dần
SELECT p.project_name, COUNT(*) AS so_nhanvien 
FROM projects p 
JOIN employee_projects ep ON p.project_id = ep.project_id
GROUP BY p.project_name
ORDER BY so_nhanvien DESC; 

-- Tính lương trung bình của nhân viên trong từng phòng ban tham gia dự án
SELECT d.department_name, AVG(e.salary) AS luong_trungbinh
FROM employees e 
JOIN departments d ON e.department_id = d.department_id
JOIN employee_projects ep ON e.employee_id = ep.employee_id
GROUP BY d.department_name; 

-- Tìm tên nhân viên và dự án mà họ tham gia ít nhất một lần trong mỗi phòng ban
SELECT e.name, p.project_name, d.department_name
FROM employees e 
JOIN departments d ON e.department_id = d.department_id
JOIN employee_projects ep ON e.employee_id = ep.employee_id
JOIN projects p ON ep.project_id = p.project_id;

-- Tìm tên nhân viên và số lượng dự án mà họ tham gia nhiều nhất
SELECT e.name, COUNT(*) AS so_du_an
FROM employees e 
JOIN employee_projects ep ON e.employee_id = ep.employee_id
GROUP BY e.name; 

-- Tìm tên phòng ban và số lượng dự án mà phòng ban đó quản lý nhiều nhất
SELECT d.department_name, COUNT(*) AS so_du_an
FROM departments d 
JOIN projects p ON d.department_id =  p.department_id
GROUP BY d.department_name;

-- Tìm tên nhân viên có lương thấp nhất trong từng dự án
SELECT e.name, p.project_name, e.salary
FROM employees e
JOIN employee_projects ep ON e.employee_id = ep.employee_id
JOIN projects p ON ep.project_id = p.project_id
WHERE e.salary = (
	SELECT MIN(e.salary)
	FROM employees e
	JOIN employee_projects ep ON e.employee_id = ep.employee_id
);

-- Liệt kê tên tất cả các dự án không có nhân viên tham gia
SELECT p.project_id, p.project_name  
FROM projects p 
WHERE p.project_id NOT IN (
	SELECT ep.project_id
	FROM employee_projects ep  
);

-- Tìm tên nhân viên có lương cao nhất và thấp nhất trong mỗi phòng ban
WITH DepartmentSalaries AS (
    SELECT 
        e.name,
        e.department_id,
        e.salary,
        d.department_name,
        ROW_NUMBER() OVER (PARTITION BY e.department_id ORDER BY e.salary DESC) as highest_rank,
        ROW_NUMBER() OVER (PARTITION BY e.department_id ORDER BY e.salary ASC) as lowest_rank
    FROM 
        employees e
    JOIN 
        departments d ON e.department_id = d.department_id
)

SELECT 
    department_name,
    MAX(CASE WHEN highest_rank = 1 THEN name ELSE NULL END) as luong_caonhat,
    MAX(CASE WHEN lowest_rank = 1 THEN name ELSE NULL END) as luong_thapnhat
FROM 
    DepartmentSalaries
GROUP BY 
    department_name
ORDER BY 
    department_name;
   
-- Tính tổng lương và số lượng nhân viên cho từng dự án trong mỗi phòng ban
SELECT d.department_name, p.project_name, SUM(e.salary) AS tong_luong, COUNT(*) AS so_nhanvien  
FROM departments d 
JOIN projects p ON d.department_id = p.department_id
JOIN employee_projects ep ON p.project_id = ep.project_id
JOIN employees e ON ep.employee_id = e.employee_id 
GROUP BY d.department_name, p.project_name;

-- Tìm tên các nhân viên không tham gia bất kỳ dự án nào
SELECT 
    e.name
FROM 
    employees e
LEFT JOIN 
    employee_projects ep ON e.employee_id = ep.employee_id
WHERE 
    ep.employee_id IS NULL;
   
-- Tính tổng số dự án mà mỗi phòng ban đang quản lý
SELECT d.department_name, COUNT(*) AS so_du_an 
FROM departments d 
JOIN projects p ON d.department_id =  p.department_id
GROUP BY d.department_name; 

-- Tìm tên nhân viên và tên dự án mà nhân viên có lương cao nhất tham gia trong từng phòng ban   
   WITH HighestPaidEmployees AS (
    SELECT 
        e.employee_id,
        e.name AS employee_name,
        e.department_id,
        e.salary,
        d.department_name
    FROM 
        employees e
    JOIN 
        departments d ON e.department_id = d.department_id
    WHERE 
        (e.salary, e.department_id) IN (
            SELECT 
                MAX(salary), 
                department_id
            FROM 
                employees
            GROUP BY 
                department_id
        )
)

SELECT 
    hpe.department_name,
    hpe.employee_name,
    hpe.salary AS highest_salary,
    p.project_name
FROM 
    HighestPaidEmployees hpe
JOIN 
    employee_projects ep ON hpe.employee_id = ep.employee_id
JOIN 
    projects p ON ep.project_id = p.project_id
ORDER BY 
    hpe.department_name, 
    hpe.employee_name, 
    p.project_name;

-- Tính tổng lương của nhân viên trong mỗi phòng ban theo từng dự án mà không có nhân viên tham gia dự án 
WITH ProjectsWithoutEmployees AS (
    SELECT 
        p.project_id,
        p.project_name,
        p.department_id
    FROM 
        projects p
    LEFT JOIN 
        employee_projects ep ON p.project_id = ep.project_id
    WHERE 
        ep.employee_id IS NULL
),

DepartmentSalariesForEmptyProjects AS (
    SELECT
        d.department_id,
        d.department_name,
        SUM(e.salary) AS total_salary
    FROM
        departments d
    JOIN 
        employees e ON d.department_id = e.department_id
    WHERE 
        d.department_id IN (SELECT department_id FROM ProjectsWithoutEmployees)
    GROUP BY
        d.department_id,
        d.department_name
)

SELECT
    pwe.project_name,
    dsfp.department_name,
    dsfp.total_salary
FROM
    ProjectsWithoutEmployees pwe
JOIN
    DepartmentSalariesForEmptyProjects dsfp ON pwe.department_id = dsfp.department_id
ORDER BY
    pwe.project_name,
    dsfp.department_name;
