(ns units.kinematics.si)

(def distance
  [:m 1
   :km 1000
   :cm 1/100
   :mm 1/1000])

(def time
  [:s 1
   :min 60
   :hr '(* 60 :min)
   :day '(* 24 :hr)])

(defprotocol quantity)

(defprotocol distance)

(defprotocol duration)

(defprotocol mass)



(defprotocol coordinate)

(defprotocol location)

(defprotocol instant)


;; direction a coordinate?  velocity is quantity and coordinate

(def distance
  {:base :m
   :km 1000})

(def duration
  {:base :s
   :min [* 60 :s]
   :hr [* 60 :min]
   :day [* 24 :hr]})

(def mass
  {:base :kg
   :g [/ :kg 1000]
   :mg [/ :g 1000]})

(def speed
  {:compose [/ distance duration]})

(def acceleration
  {:compose [/ speed duration]})

(def force
  {:compose [* mass acceleration]
   :base :newton})

(def energy
  {:compose [* force distance]
   :base :joule})

(def power
  {:compose [/ energy duration]
   :base :watt})

(def frequency
  {:compose [/ 1 duration]
   :base :hz
   :khz [* :hz 1000]
   :mhz [* :khz 1000]})

(eval frequency)
