<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spr" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<c:url value="/adminpanel/schedule/${doctorDataDTO.id}/" var="getSchedule"/>
<c:url value="/adminpanel/schedule/booking/${patientDataDTO.id}/" var="bookTime"/>
<c:url value="/adminpanel/ticket/${patientDataDTO.id}/${doctorDataDTO.id}/current" var="currentTicket"/>

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
    <h3>Booking a ticket to Dr. Petrov</h3>
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
                        <div class="bookingHref" style="display: none"></div>
                    </button>
            </div>
            <div class="col-xs-2">
                    <button class="thumbnail bookingButton" id="thumbnail1"
                       style="background-color: white; color: black; text-align:  center; transition: 0.35s; width: 118%; height: 80px;">
                        <div class="bookingTime" style="background-color: #ffa97d; border-radius: 10px;">9:00</div>
                        <div class="scheduleId" style="display: none"></div>
                        <div class="bookingHref" style="display: none"></div>
                    </button>
            </div>
            <div class="col-xs-2">
                    <button class="thumbnail bookingButton" id="thumbnail2"
                       style="background-color: white; color: black; text-align:  center; transition: 0.35s; width: 118%; height: 80px;">
                        <div class="bookingTime" style="background-color: #ffa97d; border-radius: 10px;">10:00</div>
                        <div class="scheduleId" style="display: none"></div>
                        <div class="bookingHref" style="display: none"></div>
                    </button>
            </div>
            <div class="col-xs-2">
                    <button class="thumbnail bookingButton" id="thumbnail3"
                       style="background-color: white; color: black; text-align:  center; transition: 0.35s; width: 118%; height: 80px;">
                        <div class="bookingTime" style="background-color: #ffa97d; border-radius: 10px;">11:00</div>
                        <div class="scheduleId" style="display: none"></div>
                        <div class="bookingHref" style="display: none"></div>
                    </button>
            </div>
            <div class="col-xs-2">
                    <button class="thumbnail bookingButton" id="thumbnail4"
                       style="background-color: white; color: black; text-align:  center; transition: 0.35s; width: 118%; height: 80px;">
                        <div class="bookingTime" style="background-color: #ffa97d; border-radius: 10px;">12:00</div>
                        <div class="scheduleId" style="display: none"></div>
                        <div class="bookingHref" style="display: none"></div>
                    </button>
            </div>
            <div class="col-xs-2">
                    <button class="thumbnail bookingButton" id="thumbnail5"
                       style="background-color: white; color: black; text-align:  center; transition: 0.35s; width: 118%; height: 80px;">
                        <div class="bookingTime" style="background-color: #ffa97d; border-radius: 10px;">13:00</div>
                        <div class="scheduleId" style="display: none"></div>
                        <div class="bookingHref" style="display: none"></div>
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
                        <div class="bookingHref" style="display: none"></div>
                    </button>
            </div>
            <div class="col-xs-2">
                    <button class="thumbnail bookingButton" id="thumbnail7"
                       style="background-color: white; color: black; text-align:  center; transition: 0.35s; width: 118%; height: 80px;">
                        <div class="bookingTime" style="background-color: #ffa97d; border-radius: 10px;">15:00</div>
                        <div class="scheduleId" style="display: none"></div>
                        <div class="bookingHref" style="display: none"></div>
                    </button>
            </div>
            <div class="col-xs-2">
                    <button class="thumbnail bookingButton" id="thumbnail8"
                       style="background-color: white; color: black; text-align:  center; transition: 0.35s; width: 118%; height: 80px;">
                        <div class="bookingTime" style="background-color: #ffa97d; border-radius: 10px;">16:00</div>
                        <div class="scheduleId" style="display: none"></div>
                        <div class="bookingHref" style="display: none"></div>
                    </button>
            </div>
            <div class="col-xs-2">
                    <button class="thumbnail bookingButton" id="thumbnail9"
                       style="background-color: white; color: black; text-align:  center; transition: 0.35s; width: 118%; height: 80px;">
                        <div class="bookingTime" style="background-color: #ffa97d; border-radius: 10px;">17:00</div>
                        <div class="scheduleId" style="display: none"></div>
                        <div class="bookingHref" style="display: none"></div>
                    </button>
            </div>
            <div class="col-xs-2">
                    <button class="thumbnail bookingButton" id="thumbnail10"
                       style="background-color: white; color: black; text-align:  center; transition: 0.35s; width: 118%; height: 80px;">
                        <div class="bookingTime" style="background-color: #ffa97d; border-radius: 10px;">18:00</div>
                        <div class="scheduleId" style="display: none"></div>
                        <div class="bookingHref" style="display: none"></div>
                    </button>
            </div>
            <div class="col-xs-2">
                    <button class="thumbnail bookingButton" id="thumbnail11"
                       style="background-color: white; color: black; text-align:  center; transition: 0.35s; width: 118%; height: 80px;">
                        <div class="bookingTime" style="background-color: #ffa97d; border-radius: 10px;">19:00</div>
                        <div class="scheduleId" style="display: none"></div>
                        <div class="bookingHref" style="display: none"></div>
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
            console.log(this)
            alert(this.style.backgroundColor)
            if (this.style.backgroundColor === 'rgb(62, 116, 146)') {
                var url = this.querySelector('.bookingHref').textContent;
                console.log(url);
                if (!isEmpty(url)) {
                    var newTicketHref = "${currentTicket}";
                    document.location.href = newTicketHref;
                }
            } else {
                var url = this.querySelector('.bookingHref').textContent;
                console.log(url);
                if (!isEmpty(url)) {
                    $.ajax({
                        url: url,
                        datatype: 'json',
                        type: 'get',
                        success: function (json) {
                            var newTicketHref = "${currentTicket}";
                            document.location.href = newTicketHref;
                        },
                        error: function (e) {
                            var message = "<spring:message code="booking.message.duplicate"/>";
                            alert(message);
                            console.log(e.responseText)
                        }
                    })
                } else {
                    var message = "<spring:message code="booking.message.error"/>";
                    alert(message);
                }
            }
        });
    });

    function getSchedule() {
        var date = document.getElementById('bookingDate').value;
        var url = "<c:url value="/adminpanel/schedule/${doctorDataDTO.id}/"/>" + date;
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
                            var bookingHref=selector[0].querySelector('.bookingHref');
                            if (json[i].available === true) {
                                selector.css('background-color', '#7DFFD4');
                                scheduleId.textContent = json[i].id;
                                bookingHref.textContent = "${bookTime}"+json[i].id;
                                console.log(selector[0].querySelector('.bookingHref').textContent);
                            } else if (json[i].available === false) {
                                if(json[i].ticket != null){
                                    console.log(json[i].ticket.patient.id)
                                    if(json[i].ticket.patient.id == ${patientDataDTO.id}){
                                        selector.css('background-color', '#3E7492');
                                        scheduleId.textContent = json[i].id;
                                        bookingHref.textContent = "${bookTime}"+json[i].id + "/dereserve";
                                    }
                                    else {
                                        selector.css('background-color', '#CC5078');
                                        scheduleId.textContent = "";
                                        bookingHref.textContent = "";
                                    }
                                }
                            } else {
                                selector.css('background-color', '#889599');
                                scheduleId.textContent = "";
                                bookingHref.textContent = "";
                            }
                        }
                    } else {
                        for (i = 0; i < 12; i++) {
                            var selector = $('#thumbnail' + i);
                            var scheduleId=selector[0].querySelector('.scheduleId');
                            var bookingHref=selector[0].querySelector('.bookingHref');
                            selector.css('background-color', '#889599');
                            scheduleId.textContent = "";
                            bookingHref.textContent = "";
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