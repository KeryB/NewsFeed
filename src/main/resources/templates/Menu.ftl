<html lang="en">
<head>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<div class="col-md-12">
    <form action="/findAllNews">
        <input type="submit" class="btn btn-primary" value="Показать все новости">
    </form>
    <form action="/find">
        <input type="submit" class="btn btn-primary" value="Найти новости по Заголовку">
    </form>
    <form action="/addNews">
        <input type="submit" class="btn btn-primary" value="Добавить новость">
    </form>
    <form action="/findContent" method="post" name="findContent">
        <input type="submit" class="btn btn-primary" value="Найти новости по контенту">
    </form>
</div>
</body>