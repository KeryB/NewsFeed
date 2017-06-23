<html lang="en">
<head>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/custom">
    <style>
        .user_card {
            box-shadow: 0 2px 3px 0 rgba(0, 0, 0, 0.33);
            width: 450px;
            height: 500px;
            padding: inherit;
        }

        .move {
            padding-left: 200px;
            padding-top: 350px;
        }
    </style>
</head>
<body>

<div class="container col-md-3">
    <div class="user_card col-md-5">
        <h3 class="card-header">Добавление новостей</h3>
        <div class="card-block">
            <form action="/save" method="post" name="updateNews" id="form">
                <div class="form-group ">
                    <label for="nameNews">Заголовок новости</label>
                    <input type="text" class="form-control" name="name" id="nameNews" placeholder="Введите заголовок" ">
                </div>
                <div class="form-group ">
                    <label for="exampleTextarea">Контент</label>
                    <textarea class="form-control" name="content" id="exampleTextarea"
                              rows="3" placeholder="Введите контент"></textarea>
                </div>
            <#if categories?size ==0>
                <label for="Categories">Категория</label>
            <select name="selected" id="Categories" form="form">
                <option>В базе нет ни одной категории:</option>
            <#else >
                <label for="Categories">Категория</label>
            <select name="selected" id="Categories" form="form">
                <option>Выберете к какой категории относиться данная новость:</option>
                <#list categories as category>
                    <option name="category_id" value="${category.category_id}"> ${category.title}</option>
                </#list>
            </#if>
                <input type="submit" class="btn btn-primary" value="Добавить новость">
            </form>
            <form action="/addCategory">
                <input type="submit" class="btn btn-primary" value="Добавить категорию">
            </form>
        </div>
        <form action="/toNews">
            <input type="submit" class="btn btn-primary" value="Отмена">
        </form>
    </div>
</div>
</body>