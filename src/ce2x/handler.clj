(ns ce2x.handler
  (:require
            [ce2x.edi :as edi]
            [clojure.java.io :as io]
            [clojure.string :as string]
            [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]))


(defn parse-edi
  [^String src
   file]
  (let [result (if (not= (string/trim src) "")
                 (let [src-bytes (.getBytes src "utf-8")]
                   (with-open [i (io/input-stream src-bytes)]
                     (edi/edi-to-xml i)))
                 (with-open [i (io/input-stream (:tempfile file))]
                   (edi/edi-to-xml i)))]
    {:headers {"Content-Type" "text/xml"}
     :body result}))


(defroutes app-routes
  ; (GET "/" [] "Hello World")
  (GET "/" [] (io/resource "public/index.html"))
  (POST "/parse-edi" [edisource edifile] (parse-edi edisource edifile))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
