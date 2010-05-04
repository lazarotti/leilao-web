package br.com.redhat.leilaoweb.dominio.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class Imagem implements Serializable {

	private static final long serialVersionUID = -712711203127335356L;

	@Column(name="nome_img")
	private String nome;
	
	@Column(name="mime_img")	
    private String mime;
	
	@Column(name="tamanho_img")	
    private long tamanho;
    
    @Lob
    @Column(name="dados_img")
    private byte[] dados;
    
    public Imagem(){
    	
    }
    
    public Imagem(String nome, String mime, long tamanho, byte[] dados) {
		super();
		this.nome = nome;
		this.mime = mime;
		this.tamanho = tamanho;
		this.dados = dados;
	}
    
	public byte[] getDados() {
        return dados;
    }
    public void setDados(byte[] dados) {
        this.dados = dados;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
        int extDot = nome.lastIndexOf('.');
        if(extDot > 0){
            String extension = nome.substring(extDot +1);
            if("bmp".equals(extension)){
                mime="image/bmp";
            } else if("jpg".equals(extension)){
                mime="image/jpeg";
            } else if("gif".equals(extension)){
                mime="image/gif";
            } else if("png".equals(extension)){
                mime="image/png";
            } else {
                mime = "image/unknown";
            }
        }
    }
    public long getTamanho() {
        return tamanho;
    }
    public void setTamanho(long tamanho) {
        this.tamanho = tamanho;
    }
    
    public String getMime(){
        return mime;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mime == null) ? 0 : mime.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + (int) (tamanho ^ (tamanho >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imagem other = (Imagem) obj;
		if (mime == null) {
			if (other.mime != null)
				return false;
		} else if (!mime.equals(other.mime))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tamanho != other.tamanho)
			return false;
		return true;
	}
    
    
}