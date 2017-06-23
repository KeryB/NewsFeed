<html lang="en">
<head>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>

<form action="/findAllNews">
    <input type="submit" class="btn btn-primary" value="Показать все новости">
</form>
<form action="/findByName">
    <div class="form-group ">
        <input type="text" class="form-control" name="news" placeholder="Введите новость">
    </div>
    <input type="submit" class="btn btn-primary" value="Найти новости по Заголовку">
</form>
<form action="/addNews">
    <input type="submit" class="btn btn-primary" value="Добавить новость">
</form>
<form action="/findByContent" method="post" name="findContent">
    <div class="form-group " >
        <input type="text" class="form-control" name="content" placeholder="Введите контент">
        <input type="submit" class="btn btn-primary" value="Найти новости по контенту">
    </div>
</form>
</body>