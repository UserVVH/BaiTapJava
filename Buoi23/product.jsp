<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Sản Phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 p-6">
    <h2 class="text-3xl font-bold mb-6">QUẢN LÝ SẢN PHẨM</h2>
    <form action="product" method="post">
        <div class="mb-4">
            <label class="block text-gray-700 mb-2" for="product-name">Tên sản phẩm</label>
            <input id="product-name" class="border rounded w-full py-2 px-3 text-gray-700" name="product-name" type="text" required>
        </div>
        <div class="mb-4">
            <label class="block text-gray-700 mb-2" for="quantity">Số lượng</label>
            <input id="quantity" class="border rounded w-full py-2 px-3 text-gray-700" name="quantity" type="number" required>
        </div>
        <div class="mb-4">
            <label class="block text-gray-700 mb-2" for="price">Giá bán</label>
            <input id="price" class="border rounded w-full py-2 px-3 text-gray-700" name="price" type="number" required>
        </div>
        <button class="bg-blue-500 text-white py-2 px-4 rounded">Lưu lại</button>
    </form>
    <div class="mt-8">
        <table class="min-w-full border">
            <thead>
                <tr class="bg-gray-100">
                    <th class="border px-4 py-2">STT</th>
                    <th class="border px-4 py-2">Tên Sản Phẩm</th>
                    <th class="border px-4 py-2">Số Lượng</th>
                    <th class="border px-4 py-2">Giá Bán</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${productList}">
                    <tr>
                        <td class="border px-4 py-2">${product[0]}</td>
                        <td class="border px-4 py-2">${product[1]}</td>
                        <td class="border px-4 py-2">${product[2]}</td>
                        <td class="border px-4 py-2">${product[3]}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
