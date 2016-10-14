using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ArvoreBinaria
{
    public class Arvore<T>
    {
        private No<T> Raiz { get; set; }

        private void AdicionarNo(No<T> no,T valor)
        {
            if(no == null)
            {
                No<T> novoNo = new No<T>(valor);
                if (Raiz == null) Raiz = novoNo;
                return;
            }
            else
            {
                if(no.Compare(valor) > 0)
                {
                    if(no.Esquerdo != null)
                    {
                        AdicionarNo(no.Esquerdo, valor);
                    }else
                    {
                        no.Esquerdo = new No<T>(valor);
                    }
                }else
                {
                    if (no.Direito != null)
                    {
                        AdicionarNo(no.Direito, valor);
                    }
                    else
                    {
                        no.Direito = new No<T>(valor);
                    }
                }
            }
            
        }

        public void Add(T valor)
        {
            AdicionarNo(Raiz, valor);
        }
    }
}
