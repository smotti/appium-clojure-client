(ns appium-clojure-client.find)

(defmacro defind
  [fn-name fn-singular fn-plural]
  `(do
     (defmulti ~fn-name
       (fn [_# _# & [category#]]
         (if (nil? category#)
           :singular
           category#)))
     
     (defmethod ~fn-name
       :singular
       [driver# value# & _#]
       (~fn-singular driver# value#))
     
     (defmethod ~fn-name
       :plural
       [driver# value# & _#]
       (~fn-plural driver# value#))))

(defind by .findElement .findElements)

(defind by-class-name .findElementByClassName .findElementsByClassName)

(defind by-css-selector .findElementByCssSelector .findElementsByCssSelector)

(defind by-id .findElementById .findElementsById)

(defind by-link-text .findElementByLinkText .findElementsByLinkText)

(defind by-name .findElementByName .findElementsByName)

(defind by-partial-link-text .findElementByPartialLinkText .findElementsByPartialLinkText)

(defind by-tag-name .findElementByTagName .findElementsByTagName)

(defind by-x-path .findElementByXPath .findElementsByXPath)
