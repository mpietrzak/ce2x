(defproject ce2x "0.1.0-SNAPSHOT"
  :description "Clojure EDI to XML"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [org.milyn/milyn-smooks-edi "1.5"]
                 [org.milyn/milyn-edisax-parser "1.5"]
                 [org.milyn.edi.unedifact/d96a-mapping "1.5-SNAPSHOT"]
                 [org.milyn.edi.unedifact/d96b-mapping "1.5-SNAPSHOT"]
                 [org.milyn.edi.unedifact/d00a-mapping "1.5-SNAPSHOT"]
                 [org.milyn.edi.unedifact/d00b-mapping "1.5-SNAPSHOT"]]
  :java-source-paths ["src"]
  :plugins [[lein-ring "0.8.11"]]
  :ring {:handler ce2x.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
