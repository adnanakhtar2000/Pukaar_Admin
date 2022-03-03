package com.example.pukaaradmin.Response;

import com.google.gson.annotations.SerializedName;

public class Historical_Data_Response {

        @SerializedName("total_mood")
        public long total_mood = 0;
        @SerializedName("anxiety")
        public long anxiety = 0;
        @SerializedName("confidence")
        public long confidence = 0;
        @SerializedName("energy_level")
        public long energy_level = 0;

        public long getTotal_mood() {
            return total_mood;
        }

        public void setTotal_mood(long total_mood) {
            this.total_mood = total_mood;
        }

        public long getAnxiety() {
            return anxiety;
        }

        public void setAnxiety(long anxiety) {
            this.anxiety = anxiety;
        }

        public long getConfidence() {
            return confidence;
        }

        public void setConfidence(long confidence) {
            this.confidence = confidence;
        }

        public long getEnergy_level() {
            return energy_level;
        }

        public void setEnergy_level(long energy_level) {
            this.energy_level = energy_level;
        }

        public long getPositive_entries() {
            return positive_entries;
        }

        public void setPositive_entries(long positive_entries) {
            this.positive_entries = positive_entries;
        }

        public long getNegetive_entries() {
            return negetive_entries;
        }

        public void setNegetive_entries(long negetive_entries) {
            this.negetive_entries = negetive_entries;
        }

        public String getFirst_time() {
            return first_time;
        }

        public void setFirst_time(String first_time) {
            this.first_time = first_time;
        }

        public String getLast_time() {
            return last_time;
        }

        public void setLast_time(String last_time) {
            this.last_time = last_time;
        }

        @SerializedName("positive_entries")
        public long positive_entries = 0;
        @SerializedName("negetive_entries")
        public long negetive_entries = 0;
       @SerializedName("first_time")
        public String first_time = "";
        @SerializedName("last_time")
        public String last_time = "";

    }
