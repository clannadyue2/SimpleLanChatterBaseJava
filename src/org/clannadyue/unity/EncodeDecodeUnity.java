package org.clannadyue.unity;

/**
 * 编解码操作的工具类
 */
public class EncodeDecodeUnity {

    public static String unicodeDecode(String in) {
        try {
            return unicodeDecode(in.toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return in;
    }

    private static String unicodeDecode(char[] in) throws Exception {
        int off = 0;
        char c;
        char[] out = new char[in.length];
        int outLen = 0;
        while (off < in.length) {
            c = in[off++];
            if (c == '\\') {
                if (in.length > off) { // �Ƿ�����һ���ַ�  
                    c = in[off++]; // ȡ����һ���ַ�  
                } else {
                    out[outLen++] = '\\'; // ĩ�ַ�Ϊ'\'������  
                    break;
                }
                if (c == 'u') { // �����"\\u"  
                    int value = 0;
                    if (in.length > off + 4) { // �ж�"\\u"����Ƿ����ĸ��ַ�  
                        boolean isUnicode = true;
                        for (int i = 0; i < 4; i++) { // �����ĸ��ַ�  
                            c = in[off++];
                            switch (c) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    value = (value << 4) + c - '0';
                                    break;
                                case 'a':
                                case 'b':
                                case 'c':
                                case 'd':
                                case 'e':
                                case 'f':
                                    value = (value << 4) + 10 + c - 'a';
                                    break;
                                case 'A':
                                case 'B':
                                case 'C':
                                case 'D':
                                case 'E':
                                case 'F':
                                    value = (value << 4) + 10 + c - 'A';
                                    break;
                                default:
                                    isUnicode = false; // �ж��Ƿ�Ϊunicode��  
                            }
                        }
                        if (isUnicode) { // ��unicode��ת��Ϊ�ַ�  
                            out[outLen++] = (char) value;
                        } else { // ����unicode���"\\uXXXX"���뷵��ֵ  
                            off = off - 4;
                            out[outLen++] = '\\';
                            out[outLen++] = 'u';
                            out[outLen++] = in[off++];
                        }
                    } else { // �����ĸ��ַ����"\\u"���뷵�ؽ�����  
                        out[outLen++] = '\\';
                        out[outLen++] = 'u';
                        continue;
                    }
                } else {
                    switch (c) { // �ж�"\\"����Ƿ�������ַ�س���tabһ���  
                        case 't':
                            c = '\t';
                            out[outLen++] = c;
                            break;
                        case 'r':
                            c = '\r';
                            out[outLen++] = c;
                            break;
                        case 'n':
                            c = '\n';
                            out[outLen++] = c;
                            break;
                        case 'f':
                            c = '\f';
                            out[outLen++] = c;
                            break;
                        default:
                            out[outLen++] = '\\';
                            out[outLen++] = c;
                            break;
                    }
                }
            } else {
                out[outLen++] = (char) c;
            }
        }
        return new String(out, 0, outLen);
    }
}
