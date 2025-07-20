$(document).on("dialog-ready", function () {
    console.log("Dialog Ready: Custom Multifield Logic Started");
      var MULTIFIELD_CUSTOM_FIRST_ID = "multifield-custom-insert-first";
       var multifieldCustomItemsCount = 0;
       var customMultifield = $("#" + MULTIFIELD_CUSTOM_FIRST_ID);
           if (customMultifield.length) {
            multifieldCustomItemsCount = customMultifield[0].items.length;
                }
 $("#" + MULTIFIELD_CUSTOM_FIRST_ID).on("change", function (event) {
     if (event.target.id === MULTIFIELD_CUSTOM_FIRST_ID) {
   if (event.target.items.length !== 1 && event.target.items.length > multifieldCustomItemsCount) {
                event.target.insertBefore(event.target.items.last(),event.target.items.first());
                multifieldCustomItemsCount = event.target.items.length;
                }
            }
        });
   });