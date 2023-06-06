USE student_management;

-- Sử dụng hàm count để hiển thị số lượng sinh viên ở từng nơi

SELECT address, COUNT(student_id) AS 'number_student'
FROM student
GROUP BY address;

-- Tính điểm trung bình các môn học của mỗi học viên bằng cách sử dụng hàm AVG

SELECT s.student_id,s.student_name, AVG(m.mark)
FROM student s join mark m on s.student_id = m.student_id
GROUP BY s.student_id, s.student_name;

-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15

SELECT s.student_id,s.student_name, AVG(m.mark)
FROM student s join mark m on s.student_id = m.student_id
GROUP BY s.Student_id, s.Student_name
HAVING AVG(m.mark) > 15;

-- Hiển thị thông tin các học viên có điểm trung bình lớn nhất.

SELECT s.student_id, s.student_name, AVG(m.mark)
FROM student s join mark m on s.student_id = m.student_id
GROUP BY s.student_id, s.student_name
HAVING AVG(m.mark) >= ALL (SELECT AVG(m.mark) FROM mark m GROUP BY m.student_id);