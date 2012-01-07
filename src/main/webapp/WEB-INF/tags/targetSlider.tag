<%@attribute name="name" required="true" %>
<%@attribute name="title" required="true" %>
<%@attribute name="value" required="true" %>
<%@attribute name="href" required="false" %>

<div class="single-field">
	<br />
	<h6>
		<label for="${pageScope.name}" class="fieldLabel">${pageScope.title} Score:</label>
		<span id="${pageScope.name}LabelLikert" style="float:right"></span><div id="${pageScope.name}Label">${pageScope.value}</div>
		<input type="hidden" name="${pageScope.name}" value="${pageScope.value}" id="${pageScope.name}" readonly="readonly" /> 
		<a href="${pageScope.href}" id="${pageScope.name}PopUp">(read more)</a>
	</h6>
	<div id="${pageScope.name}Slider"></div>
</div>

<script>
$(function(){
	$("#${pageScope.name}Slider").slider({
		min: 0,
		max: 5,
		step: 1,
		slide: function(event, ui) {
		$("#${pageScope.name}").val(ui.value);  // integer version - hidden
		$("#${pageScope.name}Label").html(ui.value);
		if (ui.value==0) { likertValue = "Complete Failure"; }
		else if (ui.value==1) { likertValue = "Strongly Disagree"; }
		else if (ui.value==2) { likertValue = "Disagree"; }
		else if (ui.value==3) { likertValue = "Neutral"; }
		else if (ui.value==4) { likertValue = "Agree"; }
		else{ likertValue = "Strongly Agree"; }
		$("#${pageScope.name}LabelLikert").html(likertValue);
		}
	});

	var startValue = $("#${pageScope.name}").val();
	if (startValue==3) { $("#${pageScope.name}LabelLikert").html("Neutral"); }
	$('#${pageScope.name}Slider').slider("option", "value", startValue);
	$("#${pageScope.name}Label").html(startValue);
	
	// Dialog popup
	var metricDescription = $("#${pageScope.name}Description").text();
	var $dialog = $('<div></div>')
		.html(metricDescription)
		.dialog({
			autoOpen: false,
			title: '${pageScope.title}',
			width: 600,
			minHeight: 300
		});
	$('#${pageScope.name}PopUp').click(function() {
		$dialog.dialog('open');
		// prevent the default action, e.g., following a link
		return false;
	});
	
});
</script>