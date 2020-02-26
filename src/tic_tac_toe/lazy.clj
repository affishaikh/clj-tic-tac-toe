(ns tic-tac-toe.lazy)

(defn lazy-fibo
     ([] (lazy-fibo 1 0))
     ([x y] (do (println x y) (lazy-seq (do (println "--->" x y) (cons y (lazy-fibo y (+ x y))))))))

(dorun (take 40 (map #(do (println %) (inc %)) (range))))

