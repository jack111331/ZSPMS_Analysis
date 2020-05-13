package com.google.zxing.client.result;

public final class AddressBookParsedResult extends ParsedResult {
  private final String[] addressTypes;
  
  private final String[] addresses;
  
  private final String birthday;
  
  private final String[] emailTypes;
  
  private final String[] emails;
  
  private final String[] geo;
  
  private final String instantMessenger;
  
  private final String[] names;
  
  private final String[] nicknames;
  
  private final String note;
  
  private final String org;
  
  private final String[] phoneNumbers;
  
  private final String[] phoneTypes;
  
  private final String pronunciation;
  
  private final String title;
  
  private final String[] urls;
  
  public AddressBookParsedResult(String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString1, String[] paramArrayOfString3, String[] paramArrayOfString4, String[] paramArrayOfString5, String[] paramArrayOfString6, String paramString2, String paramString3, String[] paramArrayOfString7, String[] paramArrayOfString8, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString9, String[] paramArrayOfString10) {
    super(ParsedResultType.ADDRESSBOOK);
    if (paramArrayOfString3 == null || paramArrayOfString4 == null || paramArrayOfString3.length == paramArrayOfString4.length) {
      if (paramArrayOfString5 == null || paramArrayOfString6 == null || paramArrayOfString5.length == paramArrayOfString6.length) {
        if (paramArrayOfString7 == null || paramArrayOfString8 == null || paramArrayOfString7.length == paramArrayOfString8.length) {
          this.names = paramArrayOfString1;
          this.nicknames = paramArrayOfString2;
          this.pronunciation = paramString1;
          this.phoneNumbers = paramArrayOfString3;
          this.phoneTypes = paramArrayOfString4;
          this.emails = paramArrayOfString5;
          this.emailTypes = paramArrayOfString6;
          this.instantMessenger = paramString2;
          this.note = paramString3;
          this.addresses = paramArrayOfString7;
          this.addressTypes = paramArrayOfString8;
          this.org = paramString4;
          this.birthday = paramString5;
          this.title = paramString6;
          this.urls = paramArrayOfString9;
          this.geo = paramArrayOfString10;
          return;
        } 
        throw new IllegalArgumentException("Addresses and types lengths differ");
      } 
      throw new IllegalArgumentException("Emails and types lengths differ");
    } 
    throw new IllegalArgumentException("Phone numbers and types lengths differ");
  }
  
  public AddressBookParsedResult(String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4, String[] paramArrayOfString5, String[] paramArrayOfString6, String[] paramArrayOfString7) {
    this(paramArrayOfString1, (String[])null, (String)null, paramArrayOfString2, paramArrayOfString3, paramArrayOfString4, paramArrayOfString5, (String)null, (String)null, paramArrayOfString6, paramArrayOfString7, (String)null, (String)null, (String)null, (String[])null, (String[])null);
  }
  
  public String[] getAddressTypes() {
    return this.addressTypes;
  }
  
  public String[] getAddresses() {
    return this.addresses;
  }
  
  public String getBirthday() {
    return this.birthday;
  }
  
  public String getDisplayResult() {
    StringBuilder stringBuilder = new StringBuilder(100);
    maybeAppend(this.names, stringBuilder);
    maybeAppend(this.nicknames, stringBuilder);
    maybeAppend(this.pronunciation, stringBuilder);
    maybeAppend(this.title, stringBuilder);
    maybeAppend(this.org, stringBuilder);
    maybeAppend(this.addresses, stringBuilder);
    maybeAppend(this.phoneNumbers, stringBuilder);
    maybeAppend(this.emails, stringBuilder);
    maybeAppend(this.instantMessenger, stringBuilder);
    maybeAppend(this.urls, stringBuilder);
    maybeAppend(this.birthday, stringBuilder);
    maybeAppend(this.geo, stringBuilder);
    maybeAppend(this.note, stringBuilder);
    return stringBuilder.toString();
  }
  
  public String[] getEmailTypes() {
    return this.emailTypes;
  }
  
  public String[] getEmails() {
    return this.emails;
  }
  
  public String[] getGeo() {
    return this.geo;
  }
  
  public String getInstantMessenger() {
    return this.instantMessenger;
  }
  
  public String[] getNames() {
    return this.names;
  }
  
  public String[] getNicknames() {
    return this.nicknames;
  }
  
  public String getNote() {
    return this.note;
  }
  
  public String getOrg() {
    return this.org;
  }
  
  public String[] getPhoneNumbers() {
    return this.phoneNumbers;
  }
  
  public String[] getPhoneTypes() {
    return this.phoneTypes;
  }
  
  public String getPronunciation() {
    return this.pronunciation;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public String[] getURLs() {
    return this.urls;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\AddressBookParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */