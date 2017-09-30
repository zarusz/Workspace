using CsvHelper;
using CsvHelper.Configuration;
using DocumentFormat.OpenXml.Packaging;
using DocumentFormat.OpenXml.Wordprocessing;
using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace WordTemplateFill
{
    class Program
    {
        const string InPath = @"e:\dev\temp";
        const string OutPath = @"e:\dev\temp\out";

        const string WordTemplateFile = "ODCINEK ZBIOROWY 2TT 200 000 AKCJI SERII W.docx";
        const string CsvFile = "II tura WYDANE AKCJE 25.09.17.csv";

        static void Main(string[] args)
        {
            /*
             Replaces the following placeholders in the Word template with values from CSV file.
            
             [LICZBA] 
             [ZAKRES_OD]
             [ZAKRES_DO]
             [DATA]
             [WARTOSC]
             */         

            try
            {
                CleanOutFolder();

                ForEachRow(CsvFile, row =>
                {
                    var rowData = new Dictionary<string, string>
                    {
                        { "[LICZBA]", row.GetField<string>("Liczba  akcji") },
                        { "[ZAKRES_OD]", row.GetField<string>("Numery od") },
                        { "[ZAKRES_DO]", row.GetField<string>("Numery do") },
                        { "[DATA]", "11 sierpnia 2017" },
                        { "[WARTOSC]", row.GetField<string>("Wartość akcji").Replace(" zł", "") }
                    };
                    FillTemplate(WordTemplateFile, rowData, "[ZAKRES_OD]");
                });

            }
            catch (Exception e)
            {
                Console.WriteLine("Error: " + e);
            }
        }

        private static void CleanOutFolder()
        {
            if (Directory.Exists(OutPath))
            {
                Directory.Delete(OutPath, true);
            }
            Directory.CreateDirectory(OutPath);
        }

        private static void ForEachRow(string csvFile, Action<CsvReader> rowConsumer)
        {
            var csvFilePath = Path.Combine(InPath, csvFile);
            using (var textReader = new StreamReader(new FileStream(csvFilePath, FileMode.Open, FileAccess.Read), Encoding.Unicode))
            {
                var csvConfig = new CsvConfiguration
                {
                    Delimiter = "\t"
                };
                var csv = new CsvReader(textReader, csvConfig);
                while (csv.Read())
                {
                    rowConsumer(csv);
                }
            }
        }

        public static void FillTemplate(string wordTemplateFile, IDictionary<string, string> data, string idKey)
        {
            var wordTemplate = Path.Combine(InPath, wordTemplateFile);
            var targetFileName = $"{Path.GetFileNameWithoutExtension(wordTemplate)} - {data[idKey]}{Path.GetExtension(wordTemplate)}";
            var targetFilePath = Path.Combine(OutPath, targetFileName);

            File.Copy(wordTemplate, targetFilePath, true);

            using (WordprocessingDocument myDoc = WordprocessingDocument.Open(targetFilePath, true))
            {
                MainDocumentPart mainPart = myDoc.MainDocumentPart;

                Document doc = mainPart.Document;

                var xml = new StringBuilder(doc.InnerXml);

                foreach(var entry in data)
                {
                    xml.Replace(entry.Key, entry.Value);
                }

                doc.InnerXml = xml.ToString();

                myDoc.Save();
            }
        }
    }
}
