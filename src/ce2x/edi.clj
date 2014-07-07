(ns ce2x.edi
  "EDI file support"
  (:import [org.milyn.edisax.unedifact UNEdifactInterchangeParser]
           [org.milyn.edisax EDIParser]
           [java.io PrintWriter StringWriter]
           (org.xml.sax InputSource)
           (ce2x OutputHandler))
  )


(defn edi-to-xml
  [edi-in]
  (let [parser (UNEdifactInterchangeParser.)
        string-writer (StringWriter.)
        print-writer (PrintWriter. string-writer)
        output-handler (OutputHandler. print-writer)
        input-source (InputSource. edi-in)]
    (.setFeature parser EDIParser/FEATURE_IGNORE_NEWLINES true)
    ; (.setFeature parser EDIParser/FEATURE_VALIDATE true)
    (.setContentHandler parser output-handler)
    (.parse parser input-source)
    (.toString string-writer)))

