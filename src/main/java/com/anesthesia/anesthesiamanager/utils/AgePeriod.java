//package com.anesthesia.anesthesiamanager.utils;
//
//public enum AgePeriod {
//    WEEK("tygodnie"), MONTH("miesiące"), YEAR("lata");
//
//    private String fieldDescription;
//
//    AgePeriod(String value) {
//        fieldDescription = value;
//    }
//
//    public String getFieldDescription() {
//        return fieldDescription;
//    }
//
//    public static String getAgePeriodName(AgePeriod timeAgePeriod, int patientAge) {
//        switch (timeAgePeriod) {
//            case WEEK:
//                if (patientAge == 1) {
//                    return "1 tydzień";
//                } else if (patientAge < 4) {
//                    return patientAge + " tygodnie";
//                }
//            case MONTH:
//                if (patientAge == 1) {
//                    return "1 miesiąc";
//                } else if (patientAge > 1 && patientAge < 5) {
//                    return patientAge + " miesiące";
//                } else if (patientAge < 12) {
//                    return patientAge + " miesięcy";
//                }
//            case YEAR:
//                if (patientAge == 1) {
//                    return "1 rok";
//                } else if (patientAge > 1 && patientAge < 5) {
//                    return patientAge + " lata";
//                } else if (patientAge < 120) {
//                    return patientAge + " lat";
//                }
//        }
//        return null;
//    }
//}
