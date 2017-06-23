<html lang="en">
<head>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <style>
        .user_card {
            box-shadow: 0 2px 3px 0 rgba(0, 0, 0, 0.33);
            width: 450px;
            height: 200px;
            padding: inherit;
        }

        .move {
            padding-left: 100px;
            margin-top: -33px;
        }
    </style>
</head>
<body>

<#if newsOfList?size ==0>
<div class="alert alert-warning">
    <strong>Внимание!</strong> Никаких новостей нет.
</div>
<form action="/cancel">
    <input type="submit" value="Назад" class="btn btn-primary"/>
</form>
<#else >
    <#list newsOfList as news>
    <div>
        <div class="user_card col-md-3">
            <h4 class="card-header">${news.name}</h4>
            <div class="card-block">
                <p class="card-text">${news.content}.</p>
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