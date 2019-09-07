package com.notify.util;

public final class NotificationUtil {

    public static final String MAIL_TEMPLATE ="<html>"+
	    "<head>"+
	    "<style>"+
	    "*{"+
	    "	font-family: Arial;"+
	    "    font-weight: normal;"+
	    "}"+
	    "#wb_Card1"+
	    "{"+
	    "   background-color: transparent;"+
	    "   background-image: none;"+
	    "   border: 1px solid #DEDEDE;"+
	    "   border-radius: 3px;"+
	    "   margin: 0;"+
	    "   padding: 0;"+
	    "   text-align: center;"+
	    "}"+
	    "#Card1-card-header"+
	    "{"+
	    "   box-sizing: border-box;"+
	    "   border-radius: 3px 3px 0 0;"+
	    "   margin: 0;"+
	    "   padding: 12px 20px 12px 20px;"+
	    "   background-color: #4CAF50;"+
	    "   color: white;"+
	    "}"+
	    "#customers {"+
	    "  border-collapse: collapse;"+
	    "  width: 100%;"+
	    "  text-align: left;"+
	    "}"+
	    ""+
	    "#customers td, #customers th {"+
	    "  padding: 8px;"+
	    "  font-size: 13px;"+
	    "}"+
	    "#customers tr:nth-child(even){background-color: #f2f2f2;}"+
	    "#customers tr:hover {background-color: #ddd;}"+
	    "#customers th {"+
	    "  text-align: left;"+
	    "  background-color: #4CAF50;"+
	    "  color: white;"+
	    "}"+
	    "</style>"+
	    "</head>"+
	    "<body>"+
	    "<div id='wb_Card1' style='position:absolute;left:25%;top:25%;width:40%;'>"+
	    "   <div id='Card1-card-header'>$$header$$</div>"+
	    "   <div id='Card1-card-body'>"+
	    "     <table id='customers'>"+
	    "  <tr>"+
	    "    <th>Schedule</th>"+
	    "    <th>Last Changed</th>"+
	    "    <th>DaysLeft</th>"+
	    "  </tr> $$data$$"+
	    "</table>"+
	    "   </div>"+
	    "</div>"+
	    "</body>"+
	    "</html>";
}
