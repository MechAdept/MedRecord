<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spr" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:url value="/schedule/${doctorDataDTO.id}/" var="getSchedule"/>
<c:url value="/medicpanel/user/" var="patientDetais"/>
<c:url value="/medicpanel/ticket/" var="ticketHref"/>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style>
        <%@include file="/resources/css/bootstrap.min.css"%>
        <%@include file="/resources/css/common.css"%>
    </style>
    <title><spring:message code="text.title.userCrud"/></title>
    <script type="text/javascript">
        <%@include file="/resources/js/jquery-3.4.1.min.js"%>
        <%@include file="/resources/js/bootstrap.min.js"%>
    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-6">
            <a href="<c:url value="/medicpanel/user"/>">
                <button type="button" class="btn btn-info"><spring:message
                        code="button.profile"/></button>
            </a>
            <a href="<c:url value="/medicpanel/schedule"/>">
                <button type="button" class="btn btn-success ml-3"><spring:message
                        code="button.schedule"/></button>
            </a>
            <a href="<c:url value="/medicpanel/user/patients"/> ">
                <button type="button" class="btn btn-info ml-3"><spring:message
                        code="button.patients"/></button>
            </a>
            <a href="<c:url value="/medicpanel/ticket"/> ">
                <button type="button" class="btn btn-info ml-3"><spring:message
                        code="button.tickets"/></button>
            </a>
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
            <div class="row">
                <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_PATIENT','ROLE_RECEPTIONIST')">
                    <a href="<c:url value="/welcome"/>"><spring:message code="button.changeRole"/></a>
                </sec:authorize>
            </div>
        </div>
    </div>
    <h4><spring:message code="text.header.scheduleOfDoctor"/> ${doctorDataDTO.surname} ${doctorDataDTO.name} ${doctorDataDTO.patronymic}</h4>
    <br>
    <b>Выберите дату: </b>
    <input type="date" id="bookingDate" name="trip-start"
           value="${formatter.format(currentDate)}"
           min="${formatter.format(currentDate)}" max="${formatter.format(maxDate)}" style="visibility: hidden">
    <br>
    <br>
    <div class="row">
        <div class="col-xs-10">
            <div class="col-xs-2">
                <button class="thumbnail bookingButton" id="thumbnail0"
                        style="background-color: white; color: black; text-align:  center; transition: 0.3s; width: 118%; height: 80px;">
                    <div class="bookingTime" style="background-color: #ffa97d; border-radius: 10px;">8:00</div>
                    <div class="scheduleId" style="display: none"></div>
                    <div class="ticketHref" style="display: none"></div>
                    <div class="patientName" style=""></div>
                </button>
            </div>
            <div class="col-xs-2">
                <button class="thumbnail bookingButton" id="thumbnail1"
                        style="background-color: white; color: black; text-align:  center; transition: 0.35s; width: 118%; height: 80px;">
                    <div class="bookingTime" style="background-color: #ffa97d; border-radius: 10px;">9:00</div>
                    <div class="scheduleId" style="display: none"></div>
                    <div class="ticketHref" style="display: none"></div>
                    <div class="patientName" style=""></div>
                </button>
            </div>
            <div class="col-xs-2">
                <button class="thumbnail bookingButton" id="thumbnail2"
                        style="background-color: white; color: black; text-align:  center; transition: 0.35s; width: 118%; height: 80px;">
                    <div class="bookingTime" style="background-color: #ffa97d; border-radius: 10px;">10:00</div>
                    <div class="scheduleId" style="display: none"></div>
                    <div class="ticketHref" style="display: none"></div>
                    <div class="patientName" style=""></div>
                </button>
            </div>
            <div class="col-xs-2">
                <button class="thumbnail bookingButton" id="thumbnail3"
                        style="background-color: white; color: black; text-align:  center; transition: 0.35s; width: 118%; height: 80px;">
                    <div class="bookingTime" style="background-color: #ffa97d; border-radius: 10px;">11:00</div>
                    <div class="scheduleId" style="display: none"></div>
                    <div class="ticketHref" style="display: none"></div>
                    <div class="patientName" style=""></div>
                </button>
            </div>
            <div class="col-xs-2">
                <button class="thumbnail bookingButton" id="thumbnail4"
                        style="background-color: white; color: black; text-align:  center; transition: 0.35s; width: 118%; height: 80px;">
                    <div class="bookingTime" style="background-color: #ffa97d; border-radius: 10px;">12:00</div>
                    <div class="scheduleId" style="display: none"></div>
                    <div class="ticketHref" style="display: none"></div>
                    <div class="patientName" style=""></div>
                </button>
            </div>
            <div class="col-xs-2">
                <button class="thumbnail bookingButton" id="thumbnail5"
                        style="background-color: white; color: black; text-align:  center; transition: 0.35s; width: 118%; height: 80px;">
                    <div class="bookingTime" style="background-color: #ffa97d; border-radius: 10px;">13:00</div>
                    <div class="scheduleId" style="display: none"></div>
                    <div class="ticketHref" style="display: none"></div>
                    <div class="patientName" style=""></div>
                </button>
            </div>
        </div>
        <div class="col-xs-2"></div>
    </div>
    <div class="row">
        <div class="col-xs-10">
            <div class="col-xs-2">
                <button class="thumbnail bookingButton" id="thumbnail6"
                        style="background-color: white; color: black; text-align:  center; transition: 0.35s; width: 118%; height: 80px;">
                    <div class="bookingTime" style="background-color: #ffa97d; border-radius: 10px;">14:00</div>
                    <div class="scheduleId" style="display: none"></div>
                    <div class="ticketHref" style="display: none"></div>
                    <div class="patientName" style=""></div>
                </button>
            </div>
            <div class="col-xs-2">
                <button class="thumbnail bookingButton" id="thumbnail7"
                        style="background-color: white; color: black; text-align:  center; transition: 0.35s; width: 118%; height: 80px;">
                    <div class="bookingTime" style="background-color: #ffa97d; border-radius: 10px;">15:00</div>
                    <div class="scheduleId" style="display: none"></div>
                    <div class="ticketHref" style="display: none"></div>
                    <div class="patientName" style=""></div>
                </button>
            </div>
            <div class="col-xs-2">
                <button class="thumbnail bookingButton" id="thumbnail8"
                        style="background-color: white; color: black; text-align:  center; transition: 0.35s; width: 118%; height: 80px;">
                    <div class="bookingTime" style="background-color: #ffa97d; border-radius: 10px;">16:00</div>
                    <div class="scheduleId" style="display: none"></div>
                    <div class="ticketHref" style="display: none"></div>
                    <div class="patientName" style=""></div>
                </button>
            </div>
            <div class="col-xs-2">
                <button class="thumbnail bookingButton" id="thumbnail9"
                        style="background-color: white; color: black; text-align:  center; transition: 0.35s; width: 118%; height: 80px;">
                    <div class="bookingTime" style="background-color: #ffa97d; border-radius: 10px;">17:00</div>
                    <div class="scheduleId" style="display: none"></div>
                    <div class="ticketHref" style="display: none"></div>
                    <div class="patientName" style=""></div>
                </button>
            </div>
            <div class="col-xs-2">
                <button class="thumbnail bookingButton" id="thumbnail10"
                        style="background-color: white; color: black; text-align:  center; transition: 0.35s; width: 118%; height: 80px;">
                    <div class="bookingTime" style="background-color: #ffa97d; border-radius: 10px;">18:00</div>
                    <div class="scheduleId" style="display: none"></div>
                    <div class="ticketHref" style="display: none"></div>
                    <div class="patientName" style=""></div>
                </button>
            </div>
            <div class="col-xs-2">
                <button class="thumbnail bookingButton" id="thumbnail11"
                        style="background-color: white; color: black; text-align:  center; transition: 0.35s; width: 118%; height: 80px;">
                    <div class="bookingTime" style="background-color: #ffa97d; border-radius: 10px;">19:00</div>
                    <div class="scheduleId" style="display: none"></div>
                    <div class="ticketHref" style="display: none"></div>
                    <div class="patientName" style=""></div>
                </button>
            </div>
            <div class="col-xs-2"></div>
        </div>
    </div>
</div>
</body>
<script>

    $("#bookingDate").change(function (e) {
        getSchedule(e.target);
    });

    $(function () {
        $('.bookingButton').on('click', function () {
            if (this.style.backgroundColor === 'rgb(136, 149, 153)' || this.style.backgroundColor === 'rgb(125, 255, 212)')
            {
                var message = "<spring:message code="booking.message.ticketError"/>";
                alert(message);
            } else {
                var url = this.querySelector('.ticketHref').textContent;
                document.location.href = url;
            }
        });
    });

    function getSchedule() {
        var date = document.getElementById('bookingDate').value;
        var url = "<c:url value="/schedule/${doctorDataDTO.id}/"/>" + date;
        $.ajax({
                url: url,
                dataType: 'json',
                type: 'get',
                success: function (json) {
                    console.log(json);
                    if (json.length > 0) {
                        for (i = 0; i < 12; i++) {
                            var selector = $('#thumbnail' + i);
                            var scheduleId=selector[0].querySelector('.scheduleId');
                            var ticketHref=selector[0].querySelector('.ticketHref');
                            var patientName=selector[0].querySelector('.patientName');
                            if (json[i].available === true) {
                                selector.css('background-color', '#7DFFD4');
                                console.log(json[i]);
                                scheduleId.textContent = json[i].id;
                                ticketHref.textContent = "";
                            } else if (json[i].available === false) {
                                if(json[i].ticket != null){
                                    console.log(json[i].ticket.patient.id)
                                    if(json[i].ticket.attendance === null) {
                                        selector.css('background-color', '#fffd44');
                                        scheduleId.textContent = "";
                                        ticketHref.textContent = "${ticketHref}" + json[i].ticket.id;
                                        patientName.textContent = json[i].ticket.patient.name + " " + json[i].ticket.patient.surname;
                                    }
                                    else if (json[i].ticket.attendance === true){
                                        selector.css('background-color', '#5c5da1');
                                        scheduleId.textContent = "";
                                        ticketHref.textContent = "${ticketHref}" + json[i].ticket.id;
                                        patientName.textContent = json[i].ticket.patient.name + " " + json[i].ticket.patient.surname;
                                    }
                                    else {
                                        selector.css('background-color', '#b14d4b');
                                        scheduleId.textContent = "";
                                        ticketHref.textContent = "${ticketHref}" + json[i].ticket.id;
                                        patientName.textContent = json[i].ticket.patient.name + " " + json[i].ticket.patient.surname;
                                    }
                                }
                            } else {
                                selector.css('background-color', '#889599');
                                scheduleId.textContent = "";
                                ticketHref.textContent = "";
                                patientName.textContent = "";
                            }
                        }
                    } else {
                        for (i = 0; i < 12; i++) {
                            var selector = $('#thumbnail' + i);
                            var scheduleId=selector[0].querySelector('.scheduleId');
                            var ticketHref=selector[0].querySelector('.ticketHref');
                            var patientName=selector[0].querySelector('.patientName');
                            selector.css('background-color', '#889599');
                            scheduleId.textContent = "";
                            ticketHref.textContent = "";
                            patientName.textContent = "";
                        }
                    }
                },
                error: function () {
                    for (i = 0; i < 12; i++) {
                        var selector = $('#thumbnail' + i);
                        selector.css('background-color', '#889599');
                        selector.attr("href", "");
                    }
                }
            }
        )
    }

    function updateSchedule() {
        var date = document.getElementById('bookingDate').value;
        console.log(date);
    }

    $(document).ready(function () {
        document.getElementById('bookingDate').style.visibility = 'visible';
        getSchedule();
    });

    function isEmpty(str) {
        if (str.trim() == '')
            return true;
        return false;
    };
</script>
</html>