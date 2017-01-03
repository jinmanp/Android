//GPS 설정 체크
private boolean chkGpsService() {

  String gps = android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
  Log.d(gps, "aaaa");
  
  if (!(gps.matches(".*gps.*") && gps.matches(".*network.*"))) {
    // GPS OFF 일때 Dialog 표시 
    AlertDialog.Builder gsDialog = new AlertDialog.Builder(this); 
    gsDialog.setTitle("위치 서비스 설정");   
    gsDialog.setMessage("무선 네트워크 사용, GPS 위성 사용을 모두 체크하셔야 정확한 위치 서비스가 가능합니다.\n위치 서비스 기능을 설정하시겠습니까?"); 
    gsDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int which) {
        // GPS설정 화면으로 이동 
        Intent intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS); 
        intent.addCategory(Intent.CATEGORY_DEFAULT); 
        startActivity(intent);
      }
    }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int which) {
        return;
      }
    }).create().show();
    return false;
  } else {
    return true;
  }
}
