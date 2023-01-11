<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>



<section class="py-5">
	<h2 style="text-align: center;">통계</h2>
	<div class="container mt-1" style="border-top: 3px solid #000">

		<div class="tabmenu out-tabmenu">
			<ul style="list-style: none;">
				<li id="tab1" class="btnCon"><input type="radio" checked
					name="tabmenu" id="tabmenu1"> <label for="tabmenu1">일별
						가입자 수 </label>
					<div class="tabCon">
						<div id="columnchart_values" style="width: 900px; height: 500px;"></div>
					</div></li>
				<li id="tab2" class="btnCon"><input type="radio" name="tabmenu"
					id="tabmenu2"> <label for="tabmenu2">일별 리뷰등록 수 </label>
					<div class="tabCon">
						<div id="piechart_3d" style="width: 900px; height: 500px;"></div>
					</div></li>
				<li id="tab3" class="btnCon"><input type="radio" name="tabmenu"
					id="tabmenu3"> <label for="tabmenu3"> 일별 파트너십 신청 수
				</label>
					<div class="tabCon">
						<div id="donutchart" style="width: 900px; height: 500px;"></div>
					</div></li>
			</ul>
		</div>

		<br /> <br />

	</div>
</section>
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
google.charts.load("current", {
	packages : [ 'corechart' ]
});
google.charts.setOnLoadCallback(drawChart);

	function drawChart() {

		var data = google.visualization.arrayToDataTable([
				[ '일자별', ' 가입건수', {role : "style"} ],
				<c:forEach items="${user}" var="item">
				['${item[0]}', ${item[1]}, 'color: #63BFBC; opacity: 0.8'], 
				</c:forEach> 
				]);

		var view = new google.visualization.DataView(data);
	      view.setColumns([0, 1,
	                       { calc: "stringify",
	                         sourceColumn: 1,
	                         type: "string",
	                         role: "annotation" },
	                       2]);

	      var options = {
	        title: "최근 2주 일별 가입건수",
	        width: 600,
	        height: 400,
	        bar: {groupWidth: "95%"},
	        legend: { position: "none" },
	      };
	      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
	      chart.draw(view, options);
	  }

	  </script>

<script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
    		var data = google.visualization.arrayToDataTable([
				[ '일별', ' 리뷰 수' ],
				<c:forEach items="${review}" var="item">
				['${item[0]}', ${item[1]}], 
				</c:forEach> 
				]);

        var options = {
          title: '최근 2주 일별 리뷰 등록 수',
          is3D: true,
          width: 600,
	      height: 400,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
    </script>

<script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
        	[ '일별', ' 가입 수' ],
			<c:forEach items="${partner}" var="item">
			['${item[0]}', ${item[1]}], 
			</c:forEach> 
			]);

        var options = {
          title: '최근 2주 일별 파트너십 가입수 ',
          pieHole: 0.4,
          width: 600,
	      height: 400,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
      }
    </script>
<%@ include file="../layout/footer.jsp"%>

