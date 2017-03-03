(ns appium-clojure-client.navigate
  (:import (io.appium.java_client.android AndroidKeyCode AndroidDriver)
           (io.appium.java_client.ios IOSDriver)
           (io.appium.java_client.windows WindowsKeyCode WindowsDriver)))


(defn back
  [driver]
  (.. driver navigate back))

(defn forward
  [driver]
  (.. driver navigate forward))

(defn home
  [driver]
  (condp instance? driver
    AndroidDriver (.pressKeyCode driver AndroidKeyCode/HOME)
    WindowsDriver (.pressKeyCode driver WindowsKeyCode/WINDOWS)))

(defn lock
  ([driver] (lock driver 10))
  ([driver seconds]
   (condp instance? driver
    AndroidDriver (.lockDevice driver)
    IOSDriver (.lockDevice seconds))))

(defn locked?
  [driver]
  {:pre [(instance? AndroidDriver driver)]}
  (.isLocked driver))

(defn notifications
  [driver]
  {:pre [(instance? AndroidDriver driver)]}
  (.openNotifications driver))

(defn power
  [driver]
  (condp instance? driver
    AndroidDriver (.pressKeyCode driver AndroidKeyCode/KEYCODE_POWER)
    WindowsDriver (.pressKeyCode driver WindowsKeyCode/POWER)))

(defn refresh
  [driver]
  (.. driver navigate refresh))

(defn to
  [driver url]
  (.. driver navigate url))

 (defn unlock
  [driver]
  {:pre [(instance? AndroidDriver driver)]}
  (.unlockDevice driver))
