(ns appium-clojure-client.element)

(defn clear
  [e]
  (.clear e))

(defn click
  [e]  
  (.click e))

(defn attribute
  [e n]
  (.getAttribute e n))

(defn coordinates
  [e]
  (let [coords (.getCoordinates e)
        in-view-port (.inViewPort coords)
        on-page (.onPage coords)]
    {:in-view-port [(.-x in-view-port) (.-y in-view-port)]
     :on-page [(.-x on-page) (.-y on-page)]}))

(defn css-value
  [e pn] 
  (.getCssValue e pn))

(defn id
  [e]
  (.getId e))

(defn location
  [e]
  (let [p (.getLocation e)]
    [(.-x p) (.-y p)]))

(defn size
  [e]
  (let [s (.getSize e)]
    [(.-width s) (.-height s)]))

(defn tag-name
  [e]
  (.getTagName e))

(defn text
  [e]
  (.getText e))

(defn displayed?
  [e]
  (.isDisplayed e))

(defn enabled?
  [e]
  (.isEnabled e))

(defn selected?
  [e]
  (.isSelected e))

(defn send-keys
  [e ks]
  (.sendKeys e (into-array [ks])))

(defn submit
  [e]
  (.submit e))
