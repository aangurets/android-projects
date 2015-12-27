package by.aangurets.rssreader.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 * Created by aangurets on 06/12/2015.
 */
@Root(name = "channel", strict = false)
public class Channel {

    @Attribute(name = "link", required = false)
    private String atom;

    @Attribute(name = "rel", required = false)
    private String rel;

    @Attribute(name = "type", required = false)
    private String type;

    @Element(name = "title")
    private String title;

    @Element(required = false)
    private String description;

    @Element(name = "link", required = false)
    private String link;

    @Element(required = false)
    private Image image;

    @Element(required = false)
    private String language;

    @Element(required = false)
    private String pubDate;

    @Element(required = false)
    private String lastBuildDate;

    @Element(required = false)
    private String ttl;

    @Element(required = false)
    private String copyright;

    @ElementList(entry = "item", inline = true)
    ItemsList mItems;

    public Channel() {
    }

    public String getAtom() {
        return atom;
    }

    public void setAtom(String atom) {
        this.atom = atom;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public ItemsList getmItems() {
        return mItems;
    }

    public void setmItems(ItemsList mItems) {
        this.mItems = mItems;
    }
}
