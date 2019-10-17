<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:url var="create" value="/adminpanel/health/create"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@include file="/resources/css/bootstrap.min.css"%>
        <%@include file="/resources/css/common.css"%>
    </style>
    <title><spring:message code="text.title.healthCreate"/></title>
    <script type="text/javascript">
        <%@include file="/resources/js/jquery-3.4.1.min.js"%>
        <%@include file="/resources/js/bootstrap.min.js"%>
    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-6">
            <a href="<c:url value="/adminpanel/role"/>" class="btn btn-info" role="button"
               aria-pressed="true"><spring:message code="button.roles"/></a>
            <a href="<c:url value="/adminpanel/user"/>" class="btn btn-success" role="button"
               aria-pressed="true"><spring:message code="button.users"/></a>
        </div>
        <div class="col-xs-3"></div>
        <div class="col-xs-3">
            <div class="row">
                <a href="?lang=pl">PL</a>
                <a href="?lang=en">EN</a>
                <a href="?lang=ru">RU</a>
            </div>
            <div class="row">
                <a href="<c:url value="/logout"/>" type="button" class="btn btn-default"><spring:message
                        code="button.logout"/></a>
            </div>
        </div>
    </div>
    <div class="row">
        <h3><spring:message code="text.header.cardCreate"/> ${userDataDTO.username}</h3>
        <div class="container">
            <form:form modelAttribute="healthFormDTO" method="post" action="${create}">
                <form:hidden path="patientId" value="${userDataDTO.id}"/>
                <div class="col-xs-6">
                    <div class="row">
                        <div class="col-xs-6">
                            <label><spring:message code="health.label.height"/></label>
                        </div>
                        <div class="col-xs-6">
                            <form:input path="height" type="number" min="0" max="300" cssClass="form-control"
                                        placeholder="height"/>
                            <form:errors path="height" cssStyle="color: red;"></form:errors>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-xs-6">
                            <label><spring:message code="health.label.weight"/>:</label>
                        </div>
                        <div class="col-xs-6">
                            <form:input path="weight" type="number" min="0" max="500" cssClass="form-control"
                                        placeholder="weight"/>
                            <form:errors path="weight" cssStyle="color: red;"/>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-xs-6">
                            <label><spring:message code="health.label.chest"/>:</label>
                        </div>
                        <div class="col-xs-6">
                            <form:input path="chest" type="number" min="0" max="500" cssClass="form-control"
                                        placeholder="chest"/>
                            <form:errors path="chest" cssStyle="color: red;"/>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-xs-6">
                            <label><spring:message code="health.label.waist"/>:</label>
                        </div>
                        <div class="col-xs-6">
                            <form:input path="waist" type="number" min="0" max="500" cssClass="form-control"
                                        placeholder="waist"/>
                            <form:errors path="waist" cssStyle="color: red;"/>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-xs-6">
                            <label><spring:message code="health.label.hips"/>:</label>
                        </div>
                        <div class="col-xs-6">
                            <form:input path="hips" type="number" min="0" max="500" cssClass="form-control"
                                        placeholder="hips"/>
                            <form:errors path="hips" cssStyle="color: red;"/>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-xs-6">
                            <label><spring:message code="health.label.nervous"/>:</label>
                        </div>
                        <div class="col-xs-6">
                            <form:select path="nervous" class="browser-default custom-select" cssStyle="width: 18.0em">
                                <form:option value=""><spring:message code="health.alcohol.unselected"/></form:option>
                                <form:option value="Sanguine"><spring:message
                                        code="health.nervous.sanguine"/></form:option>
                                <form:option value="Choleric"><spring:message
                                        code="health.nervous.choleric"/></form:option>
                                <form:option value="Phlegmatic"><spring:message
                                        code="health.nervous.phlegmatic"/></form:option>
                                <form:option value="Melancholic"><spring:message
                                        code="health.nervous.melancholic"/></form:option>
                            </form:select>
                            <form:errors path="nervous" cssStyle="color: red"/>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-xs-6">
                            <label><spring:message code="health.label.constitution"/>:</label>
                        </div>
                        <div class="col-xs-6">
                            <form:select path="constitution" class="browser-default custom-select"
                                         cssStyle="width: 18.0em">
                                <form:option value=""><spring:message code="health.alcohol.unselected"/></form:option>
                                <form:option value="Mesomorph"><spring:message
                                        code="health.constitution.mesomorph"/></form:option>
                                <form:option value="Ectomoprh"><spring:message
                                        code="health.constitution.ectomorph"/></form:option>
                                <form:option value="Endomorph"><spring:message
                                        code="health.constitution.endomorph"/></form:option>
                            </form:select>
                            <form:errors path="constitution" cssStyle="color: red"/>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-xs-6">
                            <label><spring:message code="health.label.musculature"/>:</label>
                        </div>
                        <div class="col-xs-6">
                            <form:select path="musculature" class="browser-default custom-select"
                                         cssStyle="width: 18.0em">
                                <form:option value=""><spring:message
                                        code="health.musculature.unselected"/></form:option>
                                <form:option value="Harmonious"><spring:message
                                        code="health.musculature.harmonious"/></form:option>
                                <form:option value="Disharmonious"><spring:message
                                        code="health.musculature.disharmonious"/></form:option>
                                <form:option value="Sharply disharmonious"><spring:message
                                        code="health.musculature.sharplydisharmonious"/></form:option>
                                <form:option value="Developmental delay"><spring:message
                                        code="health.musculature.developmentaldelay"/></form:option>
                            </form:select>
                            <form:errors path="constitution" cssStyle="color: red"/>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-xs-6">
                            <label><spring:message code="health.label.leye"/>:</label>
                        </div>
                        <div class="col-xs-6">
                            <form:input path="leye" id="leye" type="range" min="-30" max="15" step="0.1"
                                        value="1"/>
                            <p>Value: <span id="lvalue"></span></p>
                            <form:errors path="leye"/>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-xs-6">
                            <label><spring:message code="health.label.reye"/>:</label>
                        </div>
                        <div class="col-xs-6">
                            <form:input path="reye" id="reye" type="range" min="-30" max="15" step="0.1"
                                        value="1"/>
                            <p>Value: <span id="rvalue"></span></p>
                            <form:errors path="reye"/>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-xs-6">
                            <label><spring:message code="health.label.blood"/>:</label>
                        </div>
                        <div class="col-xs-6">
                            <form:select path="blood" class="browser-default custom-select" cssStyle="width: 18.0em">
                                <form:option value=""><spring:message code="health.blood.unselected"/></form:option>
                                <form:option value="I+">I-</form:option>
                                <form:option value="I-">I+</form:option>
                                <form:option value="II-">II-</form:option>
                                <form:option value="II+">II+</form:option>
                                <form:option value="III-">III-</form:option>
                                <form:option value="III+">III+</form:option>
                                <form:option value="IV-">IV-</form:option>
                                <form:option value="IV+">IV+</form:option>
                            </form:select>
                            <form:errors path="blood" cssStyle="color: red"/>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-xs-6">
                            <label><spring:message code="health.label.alcohol"/>:</label>
                        </div>
                        <div class="col-xs-6">
                            <form:select path="alcohol" class="browser-default custom-select" cssStyle="width: 18.0em">
                                <form:option value=""><spring:message code="health.alcohol.unselected"/></form:option>
                                <form:option value="0"><spring:message code="health.alcohol.not"/></form:option>
                                <form:option value="1"><spring:message code="health.alcohol.use"/></form:option>
                            </form:select>
                            <form:errors path="alcohol" cssStyle="color: red"/>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-xs-6">
                            <label><spring:message code="health.label.smoke"/>:</label>
                        </div>
                        <div class="col-xs-6">
                            <form:select path="smoke" class="browser-default custom-select" cssStyle="width: 18.0em">
                                <form:option value=""><spring:message code="health.smoke.unselected"/></form:option>
                                <form:option value="0"><spring:message code="health.smoke.not"/></form:option>
                                <form:option value="1"><spring:message code="health.smoke.use"/></form:option>
                            </form:select>
                            <form:errors path="smoke" cssStyle="color: red"/>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-xs-6">
                            <label><spring:message code="health.label.drugs"/>:</label>
                        </div>
                        <div class="col-xs-6">
                            <form:select path="drugs" class="browser-default custom-select" cssStyle="width: 18.0em">
                                <form:option value=""><spring:message code="health.drugs.unselected"/></form:option>
                                <form:option value="0"><spring:message code="health.drugs.not"/></form:option>
                                <form:option value="1"><spring:message code="health.drugs.use"/></form:option>
                            </form:select>
                            <form:errors path="drugs" cssStyle="color: red"/>
                        </div>
                    </div>
                    <br>
                    <div class="col-xs-3"></div>
                    <div class="col-xs-6">
                        <form:button type="submit" value="${create}" class="btn btn-lg btn-primary btn-block">
                            <spring:message
                                    code="button.save"/>
                        </form:button>
                    </div>
                    <div class="col-xs-3"></div>
                </div>
            </form:form>
            <div class="col-xs-3"></div>
            <div class="col-xs-3"></div>
        </div>
    </div>
</div>
</body>
<script>
    function round(value, decimals) {
        return Number(Math.round(value + 'e' + decimals) + 'e-' + decimals);
    }

    var leye = document.getElementById("leye");
    var reye = document.getElementById("reye");
    var loutput = document.getElementById("lvalue");
    var routput = document.getElementById("rvalue");
    loutput.innerHTML = leye.value;
    routput.innerHTML = reye.value;

    leye.oninput = function () {
        if (isNaN(round(this.value, 1))) {
            loutput.innerHTML = 0;
            $('#leye').val(0);
        } else {
            loutput.innerHTML = round(this.value, 1);
            $('#leye').val(round(this.value, 1));
        }
    };

    reye.oninput = function () {
        if (isNaN(round(this.value, 1))) {
            routput.innerHTML = 0;
            $('#reye').val(0);
        } else {
            routput.innerHTML = round(this.value, 1);
            $('#reye').val(round(this.value, 1));
        }
    };
</script>
</html>