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
        }
    </style>
</head>
<body>

<div class="container col-md-3">
    <div class="user_card col-md-5">
        <h3 class="card-header">Добавление категории</h3>
        <div class="card-block">
            <form action="/saveCategory" method="post" name="saveCategory" id="form">
                <div class="form-group ">
                    <label for="nameNews">Заголовок категории</label>
                    <input type="text" class="form-control" name="title" id="nameNews" placeholder="Введите заголовок" ">
                </div>
                <label for="Categories">Новости</label>
                <select name="selected" id="Categories" form="form">
                    <option>Выберете к какой новости отнести данную категорию:</option>
                <#list newsList as news>
                    <option name="news_id" value="${news.news_id}"> ${news.name}</option>
                </#list>
                    <input type="submit" class="btn btn-primary" value="Сохранить изменения">
            </form>
        </div>
        <form action="/toNews">
            <input type="submit" class="btn btn-primary" value="Отмена">
        </form>
    </div>
</div>
</body>