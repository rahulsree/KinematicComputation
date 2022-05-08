(function ($) {

    $('#resultDiv').hide();
    "use strict";
//TODO: let vs. var vs. const, why function calls don't use (), what is JQuery
    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        return check;
    });

    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();
        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();
        $(thisAlert).removeClass('alert-validate');
    }

    //JQuery way of modifying HTML elements
    var targetVariable;
    var targetIndex;
    $(document).ready(function() {
        $('#targetVariable').on('change', function() {
            resetFields(); //restores original fields before removing, so that only one field could be removed
            if(this.value == '1') {
                $('#DisplacementFieldDiv').hide();
                targetVariable = "Displacement";
                targetIndex = 0;
            } else if(this.value == '2') {
                $('#TimeFieldDiv').hide();
                targetVariable = "Time";
                targetIndex = 1;
            } else if(this.value == '3') {
                $('#InitialVelocityFieldDiv').hide();
                targetVariable = "Initial Velocity";
                targetIndex = 2;
            } else if(this.value == '4') {
                $('#FinalVelocityFieldDiv').hide();
                targetVariable = "Final Velocity";
                targetIndex = 3;
            } else if(this.value == '5') {
                $('#AccelerationDiv').hide();
                targetVariable = "Acceleration";
                targetIndex = 4;
            }
        })
    })

    var excludedVariable;
    var excludedIndex;
    $(document).ready(function() {
        $('#excludedVariable').on('change', function() {
            if(this.value == '1') {
                $('#DisplacementFieldDiv').hide();
                excludedVariable = "Displacement";
                excludedIndex = 0;
            } else if(this.value == '2') {
                $('#TimeFieldDiv').hide();
                excludedVariable = "Time";
                excludedIndex = 1;
            } else if(this.value == '3') {
                $('#InitialVelocityFieldDiv').hide();
                excludedVariable = "Initial Velocity";
                excludedIndex = 2;
            } else if(this.value == '4') {
                $('#FinalVelocityFieldDiv').hide();
                excludedVariable = "Final Velocity";
                excludedIndex = 3;
            } else if(this.value == '5') {
                $('#AccelerationDiv').hide();
                excludedVariable = "Acceleration";
                excludedIndex = 4;
            }
        })
    })

    //javascript way of modifying HTML elements
    var element = document.getElementById('resetButton');
    element.addEventListener('click', resetAndClearFields) //why resetFields() doesnt work here?

    function resetFields() {
        $('#DisplacementDiv').show();
        $('#TimeFieldDiv').show();
        $('#InitialVelocityFieldDiv').show();
        $('#FinalVelocityFieldDiv').show();
        $('#AccelerationDiv').show();
    }

    function resetAndClearFields() {
        resetFields();
        clearFields();
        $('#resultDiv').hide();
    }

    function clearFields() {
        document.getElementById('DisplacementField').value = null;
        document.getElementById('TimeField').value = null;
        document.getElementById('InitialVelocityField').value = null;
        document.getElementById('FinalVelocityField').value = null;
        document.getElementById('AccelerationField').value = null;
    }

    var DisplacementField = 0;
    var TimeField = 0;
    var InitialVelocityField = 0;
    var FinalVelocityField = 0;
    var AccelerationField = 0;

    var submitElement = document.getElementById('submitButton');
    submitElement.addEventListener("click", garnerInputValues);

    let data = 0;
    function garnerInputValues() {
        if(targetIndex == 0) {
            if(document.getElementById("TimeField").value != null) {
                TimeField = document.getElementById("TimeField").value;
                TimeField = parseFloat(TimeField);
            } else {
                TimeField = 0;
            }
            if(document.getElementById("InitialVelocityField").value != null) {
                InitialVelocityField = document.getElementById("InitialVelocityField").value;
                InitialVelocityField = parseFloat(InitialVelocityField);
            } else {
                InitialVelocityField = 0;
            }

            if(document.getElementById("FinalVelocityField").value != "") {
                FinalVelocityField = document.getElementById("FinalVelocityField").value;
                FinalVelocityField = parseFloat(InitialVelocityField);
            } else {
                FinalVelocityField = 0;
            }

            if(document.getElementById("AccelerationField").value != null) {
                AccelerationField = document.getElementById("AccelerationField").value;
                AccelerationField = parseFloat(AccelerationField);
            } else {
                AccelerationField = 0;
            }
        } if(targetIndex == 1) {

            if(document.getElementById("DisplacementField").value != null) {
                DisplacementField = (document.getElementById("DisplacementField").value);
                DisplacementField = parseFloat(DisplacementField);
            } else {
                DisplacementField = 0;
            }

            if(document.getElementById("InitialVelocityField").value != null) {
                InitialVelocityField = document.getElementById("InitialVelocityField").value;
                InitialVelocityField = parseFloat(InitialVelocityField);
            } else {
                InitialVelocityField = 0;
            }

            if(document.getElementById("FinalVelocityField").value != "") {
                FinalVelocityField = document.getElementById("FinalVelocityField").value;
                FinalVelocityField = parseFloat(InitialVelocityField);
            } else {
                FinalVelocityField = 0;
            }

            if(document.getElementById("AccelerationField").value != null) {
                AccelerationField = document.getElementById("AccelerationField").value;
                AccelerationField = parseFloat(AccelerationField);
            } else {
                AccelerationField = 0;
            }
        } if(targetIndex == 2) {

            if(document.getElementById("DisplacementField").value != null) {
                DisplacementField = (document.getElementById("DisplacementField").value);
                DisplacementField = parseFloat(DisplacementField);
            } else {
                DisplacementField = 0;
            }

            if(document.getElementById("TimeField").value != null) {
                TimeField = document.getElementById("TimeField").value;
                TimeField = parseFloat(TimeField);
            } else {
                TimeField = 0;
            }

            if(document.getElementById("FinalVelocityField").value != "") {
                FinalVelocityField = document.getElementById("FinalVelocityField").value;
                FinalVelocityField = parseFloat(InitialVelocityField);
            } else {
                FinalVelocityField = 0;
            }

            if(document.getElementById("AccelerationField").value != null) {
                AccelerationField = document.getElementById("AccelerationField").value;
                AccelerationField = parseFloat(AccelerationField);
            } else {
                AccelerationField = 0;
            }
        } if(targetIndex == 3) {

            if(document.getElementById("DisplacementField").value != null) {
                DisplacementField = (document.getElementById("DisplacementField").value);
                DisplacementField = parseFloat(DisplacementField);
            } else {
                DisplacementField = 0;
            }

            if(document.getElementById("TimeField").value != null) {
                TimeField = document.getElementById("TimeField").value;
                TimeField = parseFloat(TimeField);
            } else {
                TimeField = 0;
            }

            if(document.getElementById("InitialVelocityField").value != null) {
                InitialVelocityField = document.getElementById("InitialVelocityField").value;
                InitialVelocityField = parseFloat(InitialVelocityField);
            } else {
                InitialVelocityField = 0;
            }

            if(document.getElementById("AccelerationField").value != null) {
                AccelerationField = document.getElementById("AccelerationField").value;
                AccelerationField = parseFloat(AccelerationField);
            } else {
                AccelerationField = 0;
            }
        } else if(targetIndex == 4) {
            if(document.getElementById("DisplacementField").value != null) {
                DisplacementField = (document.getElementById("DisplacementField").value);
                DisplacementField = parseFloat(DisplacementField);
            } else {
                DisplacementField = 0;
            }

            if(document.getElementById("TimeField").value != null) {
                TimeField = document.getElementById("TimeField").value;
                TimeField = parseFloat(TimeField);
            } else {
                TimeField = 0;
            }

            if(document.getElementById("InitialVelocityField").value != null) {
                InitialVelocityField = document.getElementById("InitialVelocityField").value;
                InitialVelocityField = parseFloat(InitialVelocityField);
            } else {
                InitialVelocityField = 0;
            }

            if(document.getElementById("FinalVelocityField").value != null) { //TODO: != null or != ""
                FinalVelocityField = document.getElementById("FinalVelocityField").value;
                InitialVelocityField = parseFloat(InitialVelocityField);
            } else {
                FinalVelocityField = 0;
            }
        }

        // if(document.getElementById("AccelerationField").value != null) {
        //     AccelerationField = document.getElementById("AccelerationField").value;
        // } else {
        //     AccelerationField = 0;
        // }

        const characteristics = [DisplacementField, TimeField, InitialVelocityField, FinalVelocityField, AccelerationField]; //use GET to send this to REST API
        data = characteristics;
    }

    var result;
    $(document).ready(function() {

        var dataPackage = {
            inputVector : [DisplacementField, TimeField, InitialVelocityField, FinalVelocityField, AccelerationField],
            excludedVariable : excludedIndex,
            targetVariable : targetIndex
        };
        $('#submitButton').on('click', function(){
            $.ajax({
                type:  "GET",
                dataType: "json",
                contentType: "application/json",
                url: "http://localhost:8080/computeKinematicEquation",
                data: {
                    displacement : DisplacementField,
                    time : TimeField,
                    initialVelocity : InitialVelocityField,
                    finalVelocity : FinalVelocityField,
                    acceleration : AccelerationField,
                    excludedIndex : excludedIndex,
                    targetIndex : targetIndex
                },
                success:  function(response){
                    result = response;
                    $('#resultDiv').show();
                    result = Math.trunc(result*10000)/10000;
                    document.getElementById("result").innerHTML = result;
                    // alert(result);
                },
                error:  function(){
                    alert('ERROR');
                }
            });
        });
    });
})(jQuery);