<html lang="en">
<head>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script src="/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <style>
        .user_card{
            box-shadow: 0 2px 3px 0 rgba(0, 0, 0, 0.33);
            width: 450px;
            height: 200px;
            padding: inherit;
        }
        .move{
            padding-left: 100px;
            margin-top: -33px;
        }
    </style>
</head>
<body>
<#if allNews?size ==0>
<div class="alert alert-warning">
    <strong>Внимание!</strong> Никаких новостей нет.
</div>
<form action="/cancel">
    <input type="submit" value="Отмена" class="btn btn-primary"/>
</form>
<#else >
    <#list allNews as news>
    <div>
        <div class="user_card col-md-3">
            <h4 class="card-header">${news.name}</h4>
            <div class="card-block">
                <p class="card-text">${news.content}.</p>
                <form action="/deleteNews" method="get">
                    <input type="hidden" value="${news.news_id}" name="deleteNews">
                    <input type="submit" value="Удалить" class="btn btn-primary"/>
                </form>
                <form action="/findAllNews/edit" class="move">
                    <input type="hidden" value="${news.news_id}" name="editNews">
                    <input type="submit" value="Обновить" class="btn btn-primary"/>
                </form>
            </div>
            <div class="col-md-5">
                <div>
                ${news.date_publication}
                </div>
            </div>
        </div>
    </div>
    </#list>
</#if>
</body>