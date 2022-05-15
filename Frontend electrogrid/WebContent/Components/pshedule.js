$(document).ready(function()
{
	 $("#alertSuccess").hide();
 	 $("#alertError").hide();
});

// SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
	// Clear alerts---------------------
	$("#alertSuccess").text("");
 	$("#alertSuccess").hide();
 	$("#alertError").text("");
 	$("#alertError").hide();

	// Form validation-------------------
	var status = validatepScheduleForm();
	if (status != true)
	{
		 $("#alertError").text(status);
 		 $("#alertError").show();
 		 return;
 	}
 	
	// If valid-------------------------
 	var type = ($("#hidpLidSave").val() == "") ? "POST" : "PUT";

	$.ajax(
 	{
 		url : "pshedulerAPI",
 		type : type,
 		data : $("#formItem").serialize(),
 		dataType : "text",
 		complete : function(response, status)
 		{
 			onpsheduleSaveComplete(response.responseText, status);
 		}
 	}); 
 });

function onpsheduleSaveComplete(response, status)
	{
		if (status == "success")
		{
			 var resultSet = JSON.parse(response);
 			 if (resultSet.status.trim() == "success")
			 {
 				$("#alertSuccess").text("Successfully saved.");
 				$("#alertSuccess").show();
 				$("#divpshedulerGrid").html(resultSet.data);
 			 } 
 			 else if (resultSet.status.trim() == "error")
			 {
 				$("#alertError").text(resultSet.data);
 				$("#alertError").show();
 			 }
 		} 
 		else if (status == "error")
 		{
 			$("#alertError").text("Error while saving.");
 			$("#alertError").show();
 		} 
 		else
 		{
 			$("#alertError").text("Unknown error while saving..");
 			$("#alertError").show();
 		}
		$("#hidItemIDSave").val("");
 		$("#formItem")[0].reset();
}

	// UPDATE==========================================
	$(document).on("click", ".btnUpdate", function(event)
	{
		 $("#hidpLidSave").val($(this).data("itemid"));
		 $("#ipLid").val($(this).closest("tr").find('td:eq(0)').text());
		 $("#pduration").val($(this).closest("tr").find('td:eq(1)').text());
		 $("#plocation").val($(this).closest("tr").find('td:eq(2)').text());
		  $("#preason").val($(this).closest("tr").find('td:eq(2)').text());
 		 $("#pdesc").val($(this).closest("tr").find('td:eq(3)').text());
	});
	
	
	
	$(document).on("click", ".btnRemove", function(event)
	{
 		$.ajax(
 		{
 			url : "pshedulerAPI",
 			type : "DELETE",
 			data : "pLid=" + $(this).data("plid"),
 			dataType : "text",
 			complete : function(response, status)
 			{
 				onItemDeleteComplete(response.responseText, status);
 			}
 		});
	});


	function onpsheduleDeleteComplete(response, status)
	{
		if (status == "success")
 		{
 			var resultSet = JSON.parse(response);
 			if (resultSet.status.trim() == "success")
 			{
 				$("#alertSuccess").text("Successfully deleted.");
 				$("#alertSuccess").show();
 				$("#divpshedulerGrid").html(resultSet.data);
 			} 
 			else if (resultSet.status.trim() == "error")
 			{
 				$("#alertError").text(resultSet.data);
 				$("#alertError").show();
 			}
 		} 
 		else if (status == "error")
 		{
 				$("#alertError").text("Error while deleting.");
 				$("#alertError").show();
 		} 
 		else
 		{
 				$("#alertError").text("Unknown error while deleting..");
 				$("#alertError").show();
 		}
}
	

	// CLIENT-MODEL================================================================
	function validatePsheduleForm()
	{
		// CODE
		if ($("#PLid").val().trim() == "")
		{
 			return "Insert shedule Code.";
 		}

		// DURATION
		if ($("#pduration").val().trim() == "")
 		{
 			return "Insert powercut duration.";
 		}

		// LOCATION-------------------------------
		if ($("#plocation").val().trim() == "")
 		{
 			return "Insert Location.";
 		}
 		
 			// REASON-------------------------------
		if ($("#preason").val().trim() == "")
 		{
 			return "Insert powercut reason";
 		}
 		

		// DESCRIPTION------------------------
		if ($("#pdesc").val().trim() == "")
		{
 			return "Insert powercut Description.";
 		}

		return true;
	}
	
	