var usuario=null;
var contrasena=null;


	function hacerPost(datos){

		let promise = new Promise( (resolve, reject) => {
				var putPromise = $.ajax({
				url: "/login",
				type: 'POST',
				data: JSON.stringify(datos),
				contentType: "application/json"
		});
			resolve(putPromise);
		});;
		return promise;
	}
	$(document).ready(function(){
                $(".clm_principal").remove();
		$("#button").click(function(){	
			usuario=$("#usuario").val();
			contrasena=$("#contrasena").val();
			console.log(usuario,contrasena);
			datos={"usuario":usuario,"contrasena":contrasena}
			console.log(datos);
			hacerPost(datos).then(function (data){
				//callback(data);
			});
		
		});

	});
