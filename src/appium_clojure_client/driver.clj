(ns appium-clojure-client.driver
  (:require [camel-snake-kebab.core :refer [->camelCase]])
  (:import (java.net URL)
           (io.appium.java_client AppiumDriver)
           (io.appium.java_client.android AndroidDriver)
           (io.appium.java_client.ios IOSDriver)
           (io.appium.java_client.windows WindowsDriver)
           (org.openqa.selenium.remote DesiredCapabilities)))

(defn- make-desired-capabilities
  [capabilities]
  (let [desiredCapabilities (DesiredCapabilities.)]
    (doseq [[c v] capabilities]
      (.setCapability desiredCapabilities (name (->camelCase c)) v))
    desiredCapabilities))

(defmulti make-driver
  (fn [platform url capabilities] platform))

(defmethod make-driver
  :default
  [_ url capabilities]
  (let [u (URL. url)
        cs (make-desired-capabilities capabilities)]
    (AppiumDriver. u cs)))

(defmethod make-driver
  :android
  [_ url capabilities] 
  (let [u (URL. url)
        cs (make-desired-capabilities capabilities)]
    (AndroidDriver. u cs)))

(defmethod make-driver
  :ios
  [_ url capabilities] 
  (let [u (URL. url)
        cs (make-desired-capabilities capabilities)]
    (IOSDriver. u cs)))

(defmethod make-driver
  :windows
  [_ url capabilities] 
  (let [u (URL. url)
        cs (make-desired-capabilities capabilities)]
    (WindowsDriver. u cs)))

(defn stop-driver
  [driver]
  (.quit driver))
