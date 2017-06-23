<html lang="en">
<head>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <style>
        .user_card {
            box-shadow: 0 2px 3px 0 rgba(0, 0, 0, 0.33);
            width: 450px;
            height: 200px;
            padding: inherit;
        }

        .move {
            padding-left: 100px;
        }
    </style>
</head>
<body>

<form action="/findByContent" method="post" class="col-md-4" style="padding-top: 30px">
    <div class="form-group ">
        <input type="text" class="form-control" name="news" placeholder="Введите контент">
    </div>
    <input type="submit" class="btn btn-primary" value="Найти">
</form>
<#if bool>
    <#if findContent??>
    <div class="col-lg-12">
        <div class="user_card col-md-3">
            <h4 class="card-header">${findContent.name}</h4>
            <div class="card-block">
                <p class="card-text">${findContent.content}.</p>
            </div>
            <div class="col-md-5">
                <div class="move">
                ${findContent.date_publication}
                </div>
            </div>
        </div>
    </div>
    <#else >
    <div>
        <div class="alert alert-warning">
            <strong>Внимание!</strong> По такому запросу ничего не найдено
        </div>
    </div>
    </#if>
<#else>
</#if>
</body>