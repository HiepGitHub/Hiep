package com.sss.linkboard.service.client.bing;

import java.util.List;


public class Bing {

    BingD d;

    public BingD getD() {
        return d;
    }

    public void setD(BingD d) {
        this.d = d;
    }

    public class BingD{
        private String __next;
        List<BingResult> results;

        public List<BingResult> getResults() {
            return results;
        }

        public void setResults(List<BingResult> results) {
            this.results = results;
        }

        public String get__next() {
            return __next;
        }

        public void set__next(String __next) {
            this.__next = __next;
        }
    }

    public class BingResult{
        private MetaData __metadata;

        private String Source;
        private String Description;
        private String Url;
        private String Date;
        private String ID;
        private String Title;


        public MetaData get__metadata() {
            return __metadata;
        }

        public void set__metadata(MetaData __metadata) {
            this.__metadata = __metadata;
        }

        public void setSource(String Source) {
            this.Source = Source;
        }

        public void setDescription(String Description) {
            this.Description = Description;
        }

        public void setUrl(String Url) {
            this.Url = Url;
        }

        public void setDate(String Date) {
            this.Date = Date;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getSource() {
            return Source;
        }

        public String getDescription() {
            return Description;
        }

        public String getUrl() {
            return Url;
        }

        public String getDate() {
            return Date;
        }

        public String getID() {
            return ID;
        }

        public String getTitle() {
            return Title;
        }
    }

    public class MetaData{

        private String type;
        private String uri;

        public void setType(String type) {
            this.type = type;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getType() {
            return type;
        }

        public String getUri() {
            return uri;
        }
    }
}
