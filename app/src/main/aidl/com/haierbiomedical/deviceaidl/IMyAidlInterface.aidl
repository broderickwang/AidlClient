// IMyAidlInterface.aidl
package com.haierbiomedical.deviceaidl;

import com.haierbiomedical.deviceaidl.bean.DoorBean;
import com.haierbiomedical.deviceaidl.bean.FingerBean;

// Declare any non-default types here with import statements

interface IMyAidlInterface {

    String openDoor(inout DoorBean door);

    String getDoorStatus(inout DoorBean door);

    List<DoorBean> getAllDoorStatus();

    String openFinger();

    String stopFinger();

    String seartFinger(inout FingerBean finger);

    String removeFinger(inout FingerBean finger);

    String removeAllFinger();
}