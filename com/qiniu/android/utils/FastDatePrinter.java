package com.qiniu.android.utils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public final class FastDatePrinter {
  public static final int FULL = 0;
  
  public static final int LONG = 1;
  
  private static final int MAX_DIGITS = 10;
  
  public static final int MEDIUM = 2;
  
  public static final int SHORT = 3;
  
  private final Locale mLocale;
  
  private transient int mMaxLengthEstimate;
  
  private final String mPattern;
  
  private transient Rule[] mRules;
  
  private final TimeZone mTimeZone;
  
  public FastDatePrinter(String paramString, TimeZone paramTimeZone, Locale paramLocale) {
    this.mPattern = paramString;
    this.mTimeZone = paramTimeZone;
    this.mLocale = paramLocale;
    init();
  }
  
  private static void appendDigits(Appendable paramAppendable, int paramInt) throws IOException {
    paramAppendable.append((char)(paramInt / 10 + 48));
    paramAppendable.append((char)(paramInt % 10 + 48));
  }
  
  private static void appendFullDigits(Appendable paramAppendable, int paramInt1, int paramInt2) throws IOException {
    if (paramInt1 < 10000) {
      byte b = 4;
      if (paramInt1 < 1000) {
        b = 3;
        if (paramInt1 < 100) {
          b = 2;
          if (paramInt1 < 10)
            b = 1; 
        } 
      } 
      for (paramInt2 -= b; paramInt2 > 0; paramInt2--)
        paramAppendable.append('0'); 
      int k = paramInt1;
      paramInt2 = paramInt1;
      int m = paramInt1;
      switch (b) {
        default:
          return;
        case 4:
          paramAppendable.append((char)(paramInt1 / 1000 + 48));
          k = paramInt1 % 1000;
        case 3:
          if (k >= 100) {
            paramAppendable.append((char)(k / 100 + 48));
            paramInt2 = k % 100;
          } else {
            paramAppendable.append('0');
            paramInt2 = k;
          } 
        case 2:
          if (paramInt2 >= 10) {
            paramAppendable.append((char)(paramInt2 / 10 + 48));
            m = paramInt2 % 10;
            break;
          } 
          paramAppendable.append('0');
          m = paramInt2;
          break;
        case 1:
          break;
      } 
      paramAppendable.append((char)(m + 48));
    } 
    char[] arrayOfChar = new char[10];
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    while (true) {
      j = paramInt2;
      if (i != 0) {
        arrayOfChar[paramInt1] = (char)(char)(i % 10 + 48);
        i /= 10;
        paramInt1++;
        continue;
      } 
      break;
    } 
    while (true) {
      paramInt2 = paramInt1;
      if (paramInt1 < j) {
        paramAppendable.append('0');
        j--;
        continue;
      } 
      break;
    } 
    while (--paramInt2 >= 0)
      paramAppendable.append(arrayOfChar[paramInt2]); 
  }
  
  private <B extends Appendable> B applyRules(Calendar paramCalendar, B paramB) {
    try {
      Rule[] arrayOfRule = this.mRules;
      int i = arrayOfRule.length;
      for (byte b = 0; b < i; b++)
        arrayOfRule[b].appendTo((Appendable)paramB, paramCalendar); 
    } catch (IOException iOException) {}
    return paramB;
  }
  
  private String applyRulesToString(Calendar paramCalendar) {
    return ((StringBuilder)applyRules(paramCalendar, new StringBuilder(this.mMaxLengthEstimate))).toString();
  }
  
  private void init() {
    List<Rule> list = parsePattern();
    this.mRules = list.<Rule>toArray(new Rule[list.size()]);
    int i = this.mRules.length;
    int j;
    for (j = 0; --i >= 0; j += this.mRules[i].estimateLength());
    this.mMaxLengthEstimate = j;
  }
  
  private Calendar newCalendar() {
    return Calendar.getInstance(this.mTimeZone, this.mLocale);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    paramObjectInputStream.defaultReadObject();
    init();
  }
  
  @Deprecated
  protected StringBuffer applyRules(Calendar paramCalendar, StringBuffer paramStringBuffer) {
    return applyRules(paramCalendar, paramStringBuffer);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof FastDatePrinter;
    boolean bool1 = false;
    if (!bool)
      return false; 
    paramObject = paramObject;
    bool = bool1;
    if (this.mPattern.equals(((FastDatePrinter)paramObject).mPattern)) {
      bool = bool1;
      if (this.mTimeZone.equals(((FastDatePrinter)paramObject).mTimeZone)) {
        bool = bool1;
        if (this.mLocale.equals(((FastDatePrinter)paramObject).mLocale))
          bool = true; 
      } 
    } 
    return bool;
  }
  
  public <B extends Appendable> B format(long paramLong, B paramB) {
    Calendar calendar = newCalendar();
    calendar.setTimeInMillis(paramLong);
    return applyRules(calendar, paramB);
  }
  
  public <B extends Appendable> B format(Calendar paramCalendar, B paramB) {
    Calendar calendar = paramCalendar;
    if (!paramCalendar.getTimeZone().equals(this.mTimeZone)) {
      calendar = (Calendar)paramCalendar.clone();
      calendar.setTimeZone(this.mTimeZone);
    } 
    return applyRules(calendar, paramB);
  }
  
  public <B extends Appendable> B format(Date paramDate, B paramB) {
    Calendar calendar = newCalendar();
    calendar.setTime(paramDate);
    return applyRules(calendar, paramB);
  }
  
  public String format(long paramLong) {
    Calendar calendar = newCalendar();
    calendar.setTimeInMillis(paramLong);
    return applyRulesToString(calendar);
  }
  
  String format(Object paramObject) {
    if (paramObject instanceof Date)
      return format((Date)paramObject); 
    if (paramObject instanceof Calendar)
      return format((Calendar)paramObject); 
    if (paramObject instanceof Long)
      return format(((Long)paramObject).longValue()); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unknown class: ");
    if (paramObject == null) {
      paramObject = "<null>";
    } else {
      paramObject = paramObject.getClass().getName();
    } 
    stringBuilder.append((String)paramObject);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public String format(Calendar paramCalendar) {
    return ((StringBuilder)format(paramCalendar, new StringBuilder(this.mMaxLengthEstimate))).toString();
  }
  
  public String format(Date paramDate) {
    Calendar calendar = newCalendar();
    calendar.setTime(paramDate);
    return applyRulesToString(calendar);
  }
  
  public StringBuffer format(long paramLong, StringBuffer paramStringBuffer) {
    Calendar calendar = newCalendar();
    calendar.setTimeInMillis(paramLong);
    return applyRules(calendar, paramStringBuffer);
  }
  
  @Deprecated
  public StringBuffer format(Object paramObject, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition) {
    if (paramObject instanceof Date)
      return format((Date)paramObject, paramStringBuffer); 
    if (paramObject instanceof Calendar)
      return format((Calendar)paramObject, paramStringBuffer); 
    if (paramObject instanceof Long)
      return format(((Long)paramObject).longValue(), paramStringBuffer); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unknown class: ");
    if (paramObject == null) {
      paramObject = "<null>";
    } else {
      paramObject = paramObject.getClass().getName();
    } 
    stringBuilder.append((String)paramObject);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public StringBuffer format(Calendar paramCalendar, StringBuffer paramStringBuffer) {
    return format(paramCalendar.getTime(), paramStringBuffer);
  }
  
  public StringBuffer format(Date paramDate, StringBuffer paramStringBuffer) {
    Calendar calendar = newCalendar();
    calendar.setTime(paramDate);
    return applyRules(calendar, paramStringBuffer);
  }
  
  public Locale getLocale() {
    return this.mLocale;
  }
  
  public int getMaxLengthEstimate() {
    return this.mMaxLengthEstimate;
  }
  
  public String getPattern() {
    return this.mPattern;
  }
  
  public TimeZone getTimeZone() {
    return this.mTimeZone;
  }
  
  public int hashCode() {
    return this.mPattern.hashCode() + (this.mTimeZone.hashCode() + this.mLocale.hashCode() * 13) * 13;
  }
  
  protected List<Rule> parsePattern() {
    DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
    ArrayList<NumberRule> arrayList = new ArrayList();
    String[] arrayOfString1 = dateFormatSymbols.getEras();
    String[] arrayOfString2 = dateFormatSymbols.getMonths();
    String[] arrayOfString3 = dateFormatSymbols.getShortMonths();
    String[] arrayOfString4 = dateFormatSymbols.getWeekdays();
    String[] arrayOfString5 = dateFormatSymbols.getShortWeekdays();
    String[] arrayOfString6 = dateFormatSymbols.getAmPmStrings();
    int i = this.mPattern.length();
    int[] arrayOfInt = new int[1];
    int j;
    for (j = 0; j < i; j = k + 1) {
      NumberRule numberRule6;
      TextField textField3;
      NumberRule numberRule5;
      String str1;
      CharacterLiteral characterLiteral;
      StringLiteral stringLiteral;
      NumberRule numberRule4;
      TimeZoneNumberRule timeZoneNumberRule;
      Iso8601_Rule iso8601_Rule;
      NumberRule numberRule3;
      TextField textField2;
      NumberRule numberRule2;
      String[] arrayOfString;
      TextField textField1;
      NumberRule numberRule1;
      StringBuilder stringBuilder;
      arrayOfInt[0] = j;
      String str2 = parseToken(this.mPattern, arrayOfInt);
      int k = arrayOfInt[0];
      j = str2.length();
      if (j == 0)
        break; 
      char c = str2.charAt(0);
      switch (c) {
        default:
          switch (c) {
            default:
              switch (c) {
                default:
                  stringBuilder = new StringBuilder();
                  stringBuilder.append("Illegal pattern component: ");
                  stringBuilder.append(str2);
                  throw new IllegalArgumentException(stringBuilder.toString());
                case 'y':
                  break;
                case 'w':
                  numberRule6 = selectNumberRule(3, j);
                  break;
                case 'u':
                  numberRule6 = new DayInWeekField(selectNumberRule(7, j));
                  break;
                case 's':
                  numberRule6 = selectNumberRule(13, j);
                  break;
                case 'm':
                  numberRule6 = selectNumberRule(12, j);
                  break;
                case 'k':
                  numberRule6 = new TwentyFourHourField(selectNumberRule(11, j));
                  break;
                case 'h':
                  numberRule6 = new TwelveHourField(selectNumberRule(10, j));
                  break;
                case 'd':
                  numberRule6 = selectNumberRule(5, j);
                  break;
                case 'a':
                  textField3 = new TextField(9, arrayOfString6);
                  break;
                case 'S':
                  numberRule5 = selectNumberRule(14, j);
                  break;
                case 'M':
                  if (j >= 4) {
                    TextField textField = new TextField(2, arrayOfString2);
                    break;
                  } 
                  if (j == 3) {
                    TextField textField = new TextField(2, arrayOfString3);
                    break;
                  } 
                  if (j == 2) {
                    numberRule5 = TwoDigitMonthField.INSTANCE;
                    break;
                  } 
                  numberRule5 = UnpaddedMonthField.INSTANCE;
                  break;
                case 'K':
                  numberRule5 = selectNumberRule(10, j);
                  break;
                case '\'':
                  str1 = numberRule5.substring(1);
                  if (str1.length() == 1) {
                    characterLiteral = new CharacterLiteral(str1.charAt(0));
                    break;
                  } 
                  stringLiteral = new StringLiteral((String)characterLiteral);
                  break;
              } 
            case 'Y':
              if (j == 2) {
                TwoDigitYearField twoDigitYearField = TwoDigitYearField.INSTANCE;
                break;
              } 
              c = '\004';
              if (j < 4)
                j = c; 
              numberRule4 = selectNumberRule(1, j);
              break;
            case 'Z':
              if (j == 1) {
                TimeZoneNumberRule timeZoneNumberRule1 = TimeZoneNumberRule.INSTANCE_NO_COLON;
                break;
              } 
              if (j == 2) {
                Iso8601_Rule iso8601_Rule1 = Iso8601_Rule.ISO8601_HOURS_COLON_MINUTES;
                break;
              } 
              timeZoneNumberRule = TimeZoneNumberRule.INSTANCE_COLON;
              break;
            case 'X':
              iso8601_Rule = Iso8601_Rule.getRule(j);
              break;
            case 'W':
              break;
          } 
          numberRule3 = selectNumberRule(4, j);
          break;
        case 'H':
          numberRule3 = selectNumberRule(11, j);
          break;
        case 'G':
          textField2 = new TextField(0, arrayOfString1);
          break;
        case 'F':
          numberRule2 = selectNumberRule(8, j);
          break;
        case 'E':
          if (j < 4) {
            StringBuilder stringBuilder1 = stringBuilder;
          } else {
            arrayOfString = arrayOfString4;
          } 
          textField1 = new TextField(7, arrayOfString);
          break;
        case 'D':
          numberRule1 = selectNumberRule(6, j);
          break;
      } 
      arrayList.add(numberRule1);
    } 
    return (List)arrayList;
  }
  
  protected String parseToken(String paramString, int[] paramArrayOfint) {
    int k;
    StringBuilder stringBuilder = new StringBuilder();
    int i = paramArrayOfint[0];
    int j = paramString.length();
    char c = paramString.charAt(i);
    if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
      stringBuilder.append(c);
      while (true) {
        int m = i + 1;
        k = i;
        if (m < j) {
          k = i;
          if (paramString.charAt(m) == c) {
            stringBuilder.append(c);
            i = m;
            continue;
          } 
        } 
        break;
      } 
    } else {
      stringBuilder.append('\'');
      int m = 0;
      while (true) {
        k = i;
        if (i < j) {
          c = paramString.charAt(i);
          if (c == '\'') {
            k = i + 1;
            if (k < j && paramString.charAt(k) == '\'') {
              stringBuilder.append(c);
              i = k;
            } else {
              m ^= 0x1;
            } 
          } else {
            if (m == 0 && ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
              k = i - 1;
              break;
            } 
            stringBuilder.append(c);
          } 
          i++;
          continue;
        } 
        break;
      } 
    } 
    paramArrayOfint[0] = k;
    return stringBuilder.toString();
  }
  
  protected NumberRule selectNumberRule(int paramInt1, int paramInt2) {
    switch (paramInt2) {
      default:
        return new PaddedNumberField(paramInt1, paramInt2);
      case 2:
        return new TwoDigitNumberField(paramInt1);
      case 1:
        break;
    } 
    return new UnpaddedNumberField(paramInt1);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("FastDatePrinter[");
    stringBuilder.append(this.mPattern);
    stringBuilder.append(",");
    stringBuilder.append(this.mLocale);
    stringBuilder.append(",");
    stringBuilder.append(this.mTimeZone.getID());
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  private static class CharacterLiteral implements Rule {
    private final char mValue;
    
    CharacterLiteral(char param1Char) {
      this.mValue = (char)param1Char;
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      param1Appendable.append(this.mValue);
    }
    
    public int estimateLength() {
      return 1;
    }
  }
  
  private static class DayInWeekField implements NumberRule {
    private final FastDatePrinter.NumberRule mRule;
    
    DayInWeekField(FastDatePrinter.NumberRule param1NumberRule) {
      this.mRule = param1NumberRule;
    }
    
    public void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
      this.mRule.appendTo(param1Appendable, param1Int);
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      int i = 7;
      int j = param1Calendar.get(7);
      FastDatePrinter.NumberRule numberRule = this.mRule;
      if (j != 1)
        i = j - 1; 
      numberRule.appendTo(param1Appendable, i);
    }
    
    public int estimateLength() {
      return this.mRule.estimateLength();
    }
  }
  
  private static class Iso8601_Rule implements Rule {
    static final Iso8601_Rule ISO8601_HOURS = new Iso8601_Rule(3);
    
    static final Iso8601_Rule ISO8601_HOURS_COLON_MINUTES = new Iso8601_Rule(6);
    
    static final Iso8601_Rule ISO8601_HOURS_MINUTES = new Iso8601_Rule(5);
    
    final int length;
    
    static {
    
    }
    
    Iso8601_Rule(int param1Int) {
      this.length = param1Int;
    }
    
    static Iso8601_Rule getRule(int param1Int) {
      switch (param1Int) {
        default:
          throw new IllegalArgumentException("invalid number of X");
        case 3:
          return ISO8601_HOURS_COLON_MINUTES;
        case 2:
          return ISO8601_HOURS_MINUTES;
        case 1:
          break;
      } 
      return ISO8601_HOURS;
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      int i = param1Calendar.get(15) + param1Calendar.get(16);
      if (i == 0) {
        param1Appendable.append("Z");
        return;
      } 
      if (i < 0) {
        param1Appendable.append('-');
        i = -i;
      } else {
        param1Appendable.append('+');
      } 
      int j = i / 3600000;
      FastDatePrinter.appendDigits(param1Appendable, j);
      if (this.length < 5)
        return; 
      if (this.length == 6)
        param1Appendable.append(':'); 
      FastDatePrinter.appendDigits(param1Appendable, i / 60000 - j * 60);
    }
    
    public int estimateLength() {
      return this.length;
    }
  }
  
  private static interface NumberRule extends Rule {
    void appendTo(Appendable param1Appendable, int param1Int) throws IOException;
  }
  
  private static class PaddedNumberField implements NumberRule {
    private final int mField;
    
    private final int mSize;
    
    PaddedNumberField(int param1Int1, int param1Int2) {
      if (param1Int2 >= 3) {
        this.mField = param1Int1;
        this.mSize = param1Int2;
        return;
      } 
      throw new IllegalArgumentException();
    }
    
    public final void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
      FastDatePrinter.appendFullDigits(param1Appendable, param1Int, this.mSize);
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      appendTo(param1Appendable, param1Calendar.get(this.mField));
    }
    
    public int estimateLength() {
      return this.mSize;
    }
  }
  
  private static interface Rule {
    void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException;
    
    int estimateLength();
  }
  
  private static class StringLiteral implements Rule {
    private final String mValue;
    
    StringLiteral(String param1String) {
      this.mValue = param1String;
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      param1Appendable.append(this.mValue);
    }
    
    public int estimateLength() {
      return this.mValue.length();
    }
  }
  
  private static class TextField implements Rule {
    private final int mField;
    
    private final String[] mValues;
    
    TextField(int param1Int, String[] param1ArrayOfString) {
      this.mField = param1Int;
      this.mValues = param1ArrayOfString;
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      param1Appendable.append(this.mValues[param1Calendar.get(this.mField)]);
    }
    
    public int estimateLength() {
      int i = this.mValues.length;
      int j = 0;
      while (true) {
        int k = i - 1;
        if (k >= 0) {
          int m = this.mValues[k].length();
          i = k;
          if (m > j) {
            j = m;
            i = k;
          } 
          continue;
        } 
        return j;
      } 
    }
  }
  
  private static class TimeZoneNumberRule implements Rule {
    static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
    
    static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
    
    final boolean mColon;
    
    TimeZoneNumberRule(boolean param1Boolean) {
      this.mColon = param1Boolean;
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      int i = param1Calendar.get(15) + param1Calendar.get(16);
      if (i < 0) {
        param1Appendable.append('-');
        i = -i;
      } else {
        param1Appendable.append('+');
      } 
      int j = i / 3600000;
      FastDatePrinter.appendDigits(param1Appendable, j);
      if (this.mColon)
        param1Appendable.append(':'); 
      FastDatePrinter.appendDigits(param1Appendable, i / 60000 - j * 60);
    }
    
    public int estimateLength() {
      return 5;
    }
  }
  
  private static class TwelveHourField implements NumberRule {
    private final FastDatePrinter.NumberRule mRule;
    
    TwelveHourField(FastDatePrinter.NumberRule param1NumberRule) {
      this.mRule = param1NumberRule;
    }
    
    public void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
      this.mRule.appendTo(param1Appendable, param1Int);
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      int i = param1Calendar.get(10);
      int j = i;
      if (i == 0)
        j = param1Calendar.getLeastMaximum(10) + 1; 
      this.mRule.appendTo(param1Appendable, j);
    }
    
    public int estimateLength() {
      return this.mRule.estimateLength();
    }
  }
  
  private static class TwentyFourHourField implements NumberRule {
    private final FastDatePrinter.NumberRule mRule;
    
    TwentyFourHourField(FastDatePrinter.NumberRule param1NumberRule) {
      this.mRule = param1NumberRule;
    }
    
    public void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
      this.mRule.appendTo(param1Appendable, param1Int);
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      int i = param1Calendar.get(11);
      int j = i;
      if (i == 0)
        j = param1Calendar.getMaximum(11) + 1; 
      this.mRule.appendTo(param1Appendable, j);
    }
    
    public int estimateLength() {
      return this.mRule.estimateLength();
    }
  }
  
  private static class TwoDigitMonthField implements NumberRule {
    static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();
    
    public final void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
      FastDatePrinter.appendDigits(param1Appendable, param1Int);
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      appendTo(param1Appendable, param1Calendar.get(2) + 1);
    }
    
    public int estimateLength() {
      return 2;
    }
  }
  
  private static class TwoDigitNumberField implements NumberRule {
    private final int mField;
    
    TwoDigitNumberField(int param1Int) {
      this.mField = param1Int;
    }
    
    public final void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
      if (param1Int < 100) {
        FastDatePrinter.appendDigits(param1Appendable, param1Int);
      } else {
        FastDatePrinter.appendFullDigits(param1Appendable, param1Int, 2);
      } 
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      appendTo(param1Appendable, param1Calendar.get(this.mField));
    }
    
    public int estimateLength() {
      return 2;
    }
  }
  
  private static class TwoDigitYearField implements NumberRule {
    static final TwoDigitYearField INSTANCE = new TwoDigitYearField();
    
    public final void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
      FastDatePrinter.appendDigits(param1Appendable, param1Int);
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      appendTo(param1Appendable, param1Calendar.get(1) % 100);
    }
    
    public int estimateLength() {
      return 2;
    }
  }
  
  private static class UnpaddedMonthField implements NumberRule {
    static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();
    
    public final void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
      if (param1Int < 10) {
        param1Appendable.append((char)(param1Int + 48));
      } else {
        FastDatePrinter.appendDigits(param1Appendable, param1Int);
      } 
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      appendTo(param1Appendable, param1Calendar.get(2) + 1);
    }
    
    public int estimateLength() {
      return 2;
    }
  }
  
  private static class UnpaddedNumberField implements NumberRule {
    private final int mField;
    
    UnpaddedNumberField(int param1Int) {
      this.mField = param1Int;
    }
    
    public final void appendTo(Appendable param1Appendable, int param1Int) throws IOException {
      if (param1Int < 10) {
        param1Appendable.append((char)(param1Int + 48));
      } else if (param1Int < 100) {
        FastDatePrinter.appendDigits(param1Appendable, param1Int);
      } else {
        FastDatePrinter.appendFullDigits(param1Appendable, param1Int, 1);
      } 
    }
    
    public void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException {
      appendTo(param1Appendable, param1Calendar.get(this.mField));
    }
    
    public int estimateLength() {
      return 4;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\androi\\utils\FastDatePrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */