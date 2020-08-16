<#macro login path isRegisterForm>
                    <form action="${path}" method="post" class="form-signin">
                        <div class="container" align="center">
                        <div class="row justify-content-center">
                            <div class="col-3 mt-3">
                        <h1 class="h3 mb-3 font-weight-normal">Пожалуйста, введите данные</h1>
                            </div>
                        </div>
                        <div class="row justify-content-center">
                            <div class="col-3 mt-3">
                        <input type="text" name="username" class="form-control col" placeholder="Логин" />
                            </div>
                        </div>
                        <div class="row justify-content-center">
                            <div class="col-3 mt-3 mb-2">
                        <input type="password" name="password" class="form-control" placeholder="Пароль" />
                            </div>
                        </div>
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <div class="row justify-content-center">
                            <div class="col-3 mt-3 mb-1">
                        <#if !isRegisterForm><a href="/registration" align="center">Зарегистрироваться</a></#if>
                            </div>
                        </div>
                                <div class="row justify-content-center">
                                    <div class="col-3 mt-2 mb-2">
                        <button class="btn btn-lg btn-dark btn-block"  type="submit"><#if isRegisterForm>Зарегистрировать<#else>Войти</#if></button>
                            </div>
                        </div>
                        </div>
                    </form>
</#macro>

<#macro logout>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button class="btn btn-secondary" type="submit">Выйти</button>
        </form>
</#macro>