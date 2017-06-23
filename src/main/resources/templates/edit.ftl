<html lang="en">
<head>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/custom">
    <style>
        .user_card{
            box-shadow: 0 2px 3px 0 rgba(0, 0, 0, 0.33);
            width: 450px;
            height: 500px;
            padding: inherit;
        }
        .move{
            padding-left: 200px;
        }
    </style>
</head>
<body>

<div class="container col-md-3">
    <div class="user_card col-md-5">
        <h3 class="card-header">Обновление данных</h3>
        <div class="card-block">
            <form action="/update" method="post" name="updateNews" id="form">
                <div class="form-group ">
                    <label for="nameNews">Заголовок новости</label>
                    <input type="text" class="form-control" name="name" id="nameNews" value="${edit.name}">
                </div>
                <div class="form-group ">
                    <label for="exampleTextarea">Контент</label>
                    <textarea class="form-control" name="content" id="exampleTextarea"
                              rows="3">${edit.content}</textarea>
                </div>
                <div class="form-group">
                    <label for="nameNews">Дата новости</label>
                    <input type="datetime" class="form-control" id="nameNews" value="${edit.date_publication}" disabled>
                </div>
                <input type="text" value="${edit.news_id}" name="news_id" hidden>
                <input type="submit" class="btn btn-primary" value="Обновить данные">
            </form>
        </div>
        <form action="/toNews">
            <input type="submit" class="btn btn-primary" value="Отмена">
        </form>
    </div>
</div>
</body>