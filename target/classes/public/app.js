var usuario=null;
var contrasena=null;


	function hacerPost(datos){

		let promise = new Promise( (resolve, reject) => {
				var putPromise = $.ajax({
				url: "/palabras",
				type: 'PUT',
				data: datos,
				contentType: "application/json"
		});
			resolve(putPromise);
		});;
		return promise;
	}
	$(document).ready(function(){
                $(".clm_principal").remove();
		hacerGet();
		$("#button").click(function(){
		       $(".clm_principal").remove();	
			usuario=$("#usuario").val();
			contrasena=$("#contrasena").val();
			console.log(usuario,contrasena);
			//hacerPost(cadena).then(function (data){
				//callback(data);
			//});
		
		});

	});
